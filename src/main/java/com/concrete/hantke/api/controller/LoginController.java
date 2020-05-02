package com.concrete.hantke.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.concrete.hantke.domain.service.UsuarioService;
import com.concrete.hantke.model.Login;
import com.concrete.hantke.model.RetornoSucesso;
import com.concrete.hantke.model.Usuario;

@RestController
@RequestMapping("/login")
public class LoginController 
{
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(produces = { "application/json"}, headers = "Content-type=application/json")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public RetornoSucesso login(@RequestBody Login login)
	{
		
		Usuario usuarioLogin = usuarioService.login(login);
		
		RetornoSucesso retornoSucesso = new RetornoSucesso(usuarioLogin);
	
		return retornoSucesso;
		
	}
	
}
