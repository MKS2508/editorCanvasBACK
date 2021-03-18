package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class LienzoNoEncontradoException extends RuntimeException {

	public LienzoNoEncontradoException(String identificadorLienzo) {
		super("canvas with "+identificadorLienzo +" could not be retrieved");
	}
	
}
