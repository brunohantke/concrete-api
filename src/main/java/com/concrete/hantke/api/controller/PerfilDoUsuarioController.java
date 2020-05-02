package com.concrete.hantke.api.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.concrete.hantke.domain.service.UsuarioService;
import com.concrete.hantke.model.RetornoSucesso;
import com.concrete.hantke.model.Usuario;

@RestController
@RequestMapping("/perfildousuario")
public class PerfilDoUsuarioController 
{
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(value = "/{id}",produces = {"application/json"}, headers = "Content-type=application/json")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public RetornoSucesso login(@PathVariable UUID id, @RequestHeader("Authorization") String token )
	{
		
		Usuario usuarioLogin = usuarioService.perfil(id, token);
		
		RetornoSucesso retornoSucesso = new RetornoSucesso(usuarioLogin);
	
		return retornoSucesso;
		
	}
}
