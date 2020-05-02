package com.concrete.hantke.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.concrete.hantke.domain.repository.UsuarioRepository;
import com.concrete.hantke.domain.service.UsuarioService;
import com.concrete.hantke.model.RetornoSucesso;
import com.concrete.hantke.model.Usuario;

@RestController
@RequestMapping("/cadastro")
public class CadastrosController 
{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(produces = { "application/json"}, headers = "Content-type=application/json")
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
	
	@PostMapping(produces = { "application/json"}, headers = "Content-type=application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public RetornoSucesso adicionar(@Valid @RequestBody Usuario usuario)
	{
		
		Usuario usuarioSaved = usuarioService.salvar(usuario);
		
		RetornoSucesso retornoSucesso = new RetornoSucesso(usuarioSaved);
	
		return retornoSucesso;
		
	}
	
}
