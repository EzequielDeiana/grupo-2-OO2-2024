package com.unla.oo2.grupo2.controller;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ModelAndView handleHttpRequestMethodNotSupported(HttpServletRequest request, ServletResponse res,
			HttpRequestMethodNotSupportedException ex) {
		ModelAndView modelAndView = new ModelAndView("/error/error");
		int status = ((HttpServletResponse) res).getStatus();
		System.out.println((Integer) request.getAttribute("javax.servlet.error.status_code"));
		modelAndView.addObject("statusCode", status);
		modelAndView.addObject("errorMessage", ex.getMessage());
		return modelAndView;
	}
}