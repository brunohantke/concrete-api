package com.concrete.hantke.model;

import java.time.OffsetDateTime;
import java.util.UUID;


public class RetornoSucesso 
{
	
	private UUID id;
	
	private OffsetDateTime created;
	
	private OffsetDateTime modified;
	
	private OffsetDateTime lastLogin;
	
	private String token;

	public RetornoSucesso(Usuario usuarioSaved) 
	{
		this.id = usuarioSaved.getId();
		this.created = usuarioSaved.getCreated();
		this.modified = usuarioSaved.getModified();
		this.lastLogin = usuarioSaved.getLastLogin();
		this.token = usuarioSaved.getToken();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
