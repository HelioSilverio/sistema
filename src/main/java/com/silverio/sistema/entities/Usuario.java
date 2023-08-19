package com.silverio.sistema.entities;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // //This class is an entity mapped to a database table;
@Table(name = "tb_usuario") // Name of the table in the database;
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id // Indicates that the following field is the primary key of the entity;
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies that the primary key generation is auto;
	@Column(name = "usuario_id")
	private Long id;// The primary key of the entity;

	@Column(name = "c_nomeusuario")
	private String nome;// Field to store the usuario's name;

	@Column(name = "c_emailusuario")
	private String email;

	@Column(name = "c_foneusuario")
	private String fone; // Field to store the client's phone number;
	
	@Column(name = "c_senhausuario")
	private String password;

	public Usuario() { // Default constructor
	}

	public Usuario(Long id, String nome, String email, String fone, String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.fone = fone;
		this.password = password;
	}

//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//Cod Hash
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Usuario)) {
			return false;
		}
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

}
