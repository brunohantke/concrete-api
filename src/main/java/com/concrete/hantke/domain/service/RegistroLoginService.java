package com.concrete.hantke.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concrete.hantke.domain.repository.RegistroLoginRepository;
import com.concrete.hantke.model.RegistroLogin;
import com.concrete.hantke.model.Usuario;

@Service
public class RegistroLoginService 
{
	@Autowired
	private RegistroLoginRepository registroLoginRepository;
	
	public RegistroLogin salvar(Usuario usuario)
	{
		RegistroLogin registroLogin = new RegistroLogin();
		
		registroLogin.setUsuario(usuario);
		registroLogin.setCreated(OffsetDateTime.now());
		registroLogin.setLastLogin(OffsetDateTime.now());
		
		return registroLoginRepository.save(registroLogin);
	}

}
