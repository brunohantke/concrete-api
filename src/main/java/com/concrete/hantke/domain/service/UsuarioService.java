package com.concrete.hantke.domain.service;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.concrete.hantke.config.JwtTokenUtil;
import com.concrete.hantke.domain.exception.EmailNaoExisteException;
import com.concrete.hantke.domain.exception.NegocioException;
import com.concrete.hantke.domain.exception.PasswordInvalidoException;
import com.concrete.hantke.domain.exception.SessaoInvalidaException;
import com.concrete.hantke.domain.exception.TokenNaoPermitidoException;
import com.concrete.hantke.domain.repository.UsuarioRepository;
import com.concrete.hantke.model.Login;
import com.concrete.hantke.model.Usuario;

@Service
public class UsuarioService 
{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	public Usuario salvar(Usuario usuario)
	{
		
		Usuario usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
		
		if(usuarioExistente != null && !usuarioExistente.equals(usuario))
		{
			throw new NegocioException("E-mail ja existente");
		}
		
		final String token = jwtTokenUtil.generateToken(usuario.getName());		
		usuario.setToken(token);
		
		usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getName() + usuario.getPassword()));
		usuario.setCreated(OffsetDateTime.now());
		usuario.setLastLogin(OffsetDateTime.now());
		
		Usuario usuarioSaved =  usuarioRepository.save(usuario);
		
		return usuarioSaved;	
	
	}
	
	public Usuario atualizar(Usuario usuario)
	{
		return usuarioRepository.saveAndFlush(usuario);
	}
	
	public Usuario login(Login login)
	{
		
		Usuario usuarioExistente = usuarioRepository.findByEmail(login.getEmail());
		
		if(usuarioExistente == null)
		{
			throw new EmailNaoExisteException("Usuario e/ou senha invalidos");
		}
		else if(!new BCryptPasswordEncoder().matches(usuarioExistente.getName() + login.getPassword(),usuarioExistente.getPassword()))
		{
			throw new PasswordInvalidoException("Usuario e/ou senha invalidos");
		}		
	
		usuarioExistente.setLastLogin(OffsetDateTime.now());
				
		return atualizar(usuarioExistente);
		
	}
	
	public Usuario perfil(UUID id, String token)
	{
		
		if (token.contains("Bearer"))
		{
			token.replace("Bearer ", "");
		}
		
		Usuario usuarioExistenteToken = usuarioRepository.findByToken(token);
		
		if (usuarioExistenteToken == null)
		{
			throw new TokenNaoPermitidoException("Nao autorizado");
		}
		else
		{
			Optional<Usuario> usuarioExistenteId = Optional.of(usuarioRepository.findById(id)
					.orElseThrow(() -> new TokenNaoPermitidoException("Nao autorizado")));
			
			if (!usuarioExistenteId.get().getToken().equals(usuarioExistenteToken.getToken()))
			{
				throw new TokenNaoPermitidoException("Nao autorizado");
			}
		}
		
		Duration duration = Duration.between( OffsetDateTime.now(), usuarioExistenteToken.getLastLogin());
		long diff = Math.abs(duration.toMinutes());
		
		if (diff < 30)
		{
			throw new SessaoInvalidaException("Sessao Invalida");
		}
				
		return usuarioExistenteToken;		
	}

}
