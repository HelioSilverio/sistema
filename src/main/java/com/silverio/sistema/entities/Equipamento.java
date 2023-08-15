package com.silverio.sistema.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity //This class is an entity mapped to a database table;
@Table(name = "tb_equipamento")//  Name of the table in the database;

public class Equipamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id //Indicates that the following field is the primary key of the entity;
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies that the  primary key generation is auto;
	private Long   c_codiequip;// The primary key of the entity;
	private String c_modelquip;
	private String c_seriequip;
	private String c_marcequip;
	
	
	public Equipamento() {
		super();
	}


	public Equipamento(Long c_codiequip, String c_modelquip, String c_seriequip, String c_marcequip) {
		super();
		this.c_codiequip = c_codiequip;
		this.c_modelquip = c_modelquip;
		this.c_seriequip = c_seriequip;
		this.c_marcequip = c_marcequip;
	}


	public Long getC_codiequip() {
		return c_codiequip;
	}

	// Getters and Setters
	public void setC_codiequip(Long c_codiequip) {
		this.c_codiequip = c_codiequip;
	}


	public String getC_modelquip() {
		return c_modelquip;
	}


	public void setC_modelquip(String c_modelquip) {
		this.c_modelquip = c_modelquip;
	}


	public String getC_seriequip() {
		return c_seriequip;
	}


	public void setC_seriequip(String c_seriequip) {
		this.c_seriequip = c_seriequip;
	}


	public String getC_marcequip() {
		return c_marcequip;
	}


	public void setC_marcequip(String c_marcequip) {
		this.c_marcequip = c_marcequip;
	}


	@Override// Overriding hashCode and equals methods for proper object comparison
	public int hashCode() {
		return Objects.hash(c_codiequip);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipamento other = (Equipamento) obj;
		return Objects.equals(c_codiequip, other.c_codiequip);
	}


	
		
	

}
