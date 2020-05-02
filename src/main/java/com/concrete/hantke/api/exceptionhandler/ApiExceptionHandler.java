package com.concrete.hantke.api.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.concrete.hantke.domain.exception.EmailNaoExisteException;
import com.concrete.hantke.domain.exception.NegocioException;
import com.concrete.hantke.domain.exception.SessaoInvalidaException;
import com.concrete.hantke.domain.exception.TokenNaoPermitidoException;


@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler 
{

	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Object> handleNegocio(NegocioException ex, WebRequest request)
	{
		var status = HttpStatus.BAD_REQUEST;
		
		var problema = new Problema();
		//problema.setStatus(status.value());
		problema.setErro(ex.getMessage());
		
		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(EmailNaoExisteException.class)
	public ResponseEntity<Object> handleNegocio(EmailNaoExisteException ex, WebRequest request)
	{
		var status = HttpStatus.UNAUTHORIZED;
		
		var problema = new Problema();
		problema.setErro(ex.getMessage());
		
		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(TokenNaoPermitidoException.class)
	public ResponseEntity<Object> handleNegocio(TokenNaoPermitidoException ex, WebRequest request)
	{
		var status = HttpStatus.UNAUTHORIZED;
		
		var problema = new Problema();
		problema.setErro(ex.getMessage());
		
		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
	}

	@ExceptionHandler(SessaoInvalidaException.class)
	public ResponseEntity<Object> handleNegocio(SessaoInvalidaException ex, WebRequest request)
	{
		var status = HttpStatus.FORBIDDEN;
		
		var problema = new Problema();
		problema.setErro(ex.getMessage());
		
		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
	}
	
}
