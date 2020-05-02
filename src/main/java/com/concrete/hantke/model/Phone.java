package com.concrete.hantke.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Phone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String number;
	
	private String ddd;
	
	@ManyToOne( cascade = CascadeType.PERSIST)
	@JoinColumn(name = "usuario_id" )
	private Usuario usuario;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public Phone(String number, String ddd, Usuario usuario) {
		super();

		this.number = number;
		this.ddd = ddd;

	}

	public Phone() {
		super();
	}	

}
