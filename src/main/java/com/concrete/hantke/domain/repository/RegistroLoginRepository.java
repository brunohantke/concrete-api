package com.concrete.hantke.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concrete.hantke.model.RegistroLogin;
import com.concrete.hantke.model.Usuario;

@Repository
public interface RegistroLoginRepository extends JpaRepository<RegistroLogin, Long>
{
	List<RegistroLogin> findByUsuario(Usuario usuario);	
}
