package com.ilongli.springbootvalidateddemo;


import com.ilongli.springbootvalidateddemo.common.CodeResult;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.path.NodeImpl;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Set;


/**
 * REST全局异常处理
 * @author ilongli
 */
@RestControllerAdvice(value = {"com.ilongli.springbootvalidateddemo.controller"})
@Slf4j
public class RestGlobalExceptionHandler {

	/**
	 * 接参异常异常(单个参数)
	 * @return
	 */
	@ExceptionHandler(value = ConstraintViolationException.class)
	@ResponseBody
	public CodeResult handleValidationException(ConstraintViolationException ex, HttpServletRequest request) {

		log.error("ValidationException: [{}]{}", request.getRequestURI(), ex.getMessage());
		Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();

		ArrayList<String> errorList = new ArrayList<>();

		constraintViolations.forEach(constraintViolation -> {
			PathImpl propertyPath = (PathImpl) constraintViolation.getPropertyPath();
			NodeImpl leafNode = propertyPath.getLeafNode();
			String field = leafNode.getName();
			String message = constraintViolation.getMessage();
			errorList.add("[" + field + "]" + message);
		});

		return CodeResult.error(errorList.toString());
	}


	/**
	 * 接参异常异常(实体)
	 * @return
	 */
	@ExceptionHandler(value= BindException.class)
	@ResponseBody
	public CodeResult handleBindException(BindException ex, HttpServletRequest request) {

		String requestURI = request.getRequestURI();

		log.error("BindException: [{}]{}", requestURI, ex.getMessage());

		return handleValidError(ex);
	}


	/**
	 * 接参异常异常(RequestBody)
	 * @return
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseBody
	public CodeResult handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {

		log.error("MethodArgumentNotValidException: [{}]{}", request.getRequestURI(), ex.getMessage());

		return handleValidError(ex);

	}



	private CodeResult handleValidError(BindException ex) {
		ArrayList<String> errorList = new ArrayList<>();

		ex.getBindingResult().getAllErrors().forEach(objectError -> {
			String field = ((FieldError) objectError).getField();
			String errorMsg = objectError.getDefaultMessage();
			errorList.add("[" + field + "]" + errorMsg);
		});

		return CodeResult.error(errorList.toString());
	}

}
