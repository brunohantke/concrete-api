package com.concrete.hantke.domain.exception;

public class EmailNaoExisteException extends NegocioException
{
	
	private static final long serialVersionUID = 1L;

	public EmailNaoExisteException(String message) {
		super(message);
	}

}
