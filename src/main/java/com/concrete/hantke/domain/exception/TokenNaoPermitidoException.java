package com.concrete.hantke.domain.exception;

public class TokenNaoPermitidoException  extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TokenNaoPermitidoException(String message) {
		super(message);
	}
}
