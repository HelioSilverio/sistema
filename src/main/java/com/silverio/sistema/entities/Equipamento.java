package com.silverio.sistema.entities;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity //This class is an entity mapped to a database table;
@Table(name = "tb_equipamento")//  Name of the table in the database;

public class Equipamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id //Indicates that the following field is the primary key of the entity;
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies that the  primary key generation is auto;
	@Column(name = "n_numequip")
	private Long   id;// The primary key of the entity;
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	@Column(name = "c_modelquip")
	private String modelo;
	
	@Column(name = "c_seriequip", unique = true) // Adicione a anotação unique = true aqui
	private String serie;
	
	 @Column(name = "c_marcequip")
	private String marca;
	 	
	 	// um equipamento pode ter apenas um cliente associado
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "client_id")
	 private Cliente client;
	 		
		
		
	
	 
	public Equipamento() {
		super();
	}


	public Equipamento(Long id, String modelo, String serie, String marca, Cliente client) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.serie = serie;
		this.marca = marca;
		this.client = client;
		
	}

	// Getters and Setters
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
			
	public Cliente getClient() {
		return client;
	}
	public void setClient(Cliente client) {
		this.client = client;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}


	

}


