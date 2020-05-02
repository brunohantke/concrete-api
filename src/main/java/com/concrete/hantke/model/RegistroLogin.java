package com.concrete.hantke.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "registrologin")
public class RegistroLogin 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	private OffsetDateTime created;
	
	private OffsetDateTime modified;
	
	private OffsetDateTime lastLogin;
	
	public RegistroLogin() 
	{
		super();
	}

	public RegistroLogin(Usuario usuario, OffsetDateTime created, OffsetDateTime modified, OffsetDateTime lastLogin) {
		super();
		this.usuario = usuario;
		this.created = created;
		this.modified = modified;
		this.lastLogin = lastLogin;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public OffsetDateTime getCreated() {
		return created;
	}

	public void setCreated(OffsetDateTime created) {
		this.created = created;
	}

	public OffsetDateTime getModified() {
		return modified;
	}

	public void setModified(OffsetDateTime modified) {
		this.modified = modified;
	}

	public OffsetDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(OffsetDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	
	
	

}
