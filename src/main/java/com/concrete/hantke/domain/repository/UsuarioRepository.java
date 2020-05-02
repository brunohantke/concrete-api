package com.concrete.hantke.domain.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concrete.hantke.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> 
{
	List<Usuario> findByName(String name);
	List<Usuario> findByNameContaining(String name);
	Usuario findByEmail(String email);
	Usuario findByToken(String token);
	List<Usuario> findByEmailAndPassword(String email, String password);
	List<Usuario> findByPassword(String password);
}
