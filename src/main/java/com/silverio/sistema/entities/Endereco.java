package com.silverio.sistema.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity // //This class is an entity mapped to a database table;
@Table(name = "tb_endereco")//  Name of the table in the database;
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L; 
	@Id //Indicates that the following field is the primary key of the entity;
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies that the  primary key generation is auto;
	@Column(name = "n_numend")
	private Long id;
	@Column(name = "c_cepend")
	private String cep;
	@Column(name = "c_ruaend")
	private String rua;
	@Column(name = "c_numeroend")
	private String numero;
	@Column(name = "c_bairroend")
	private String bairro;
	@Column(name = "c_cidadend")
	private String cidade;
	@Column(name = "c_estadend")
	private String estado;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id")
	 private Cliente client;
		
	
	
	public Endereco() {
		super();
	}


	public Endereco(Long id, String cep, String rua, String numero, String bairro, String cidade, String estado,Cliente client) {
		super();
		this.id = id;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.client = client;	
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}


	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}


	/**
	 * @return the rua
	 */
	public String getRua() {
		return rua;
	}


	/**
	 * @param rua the rua to set
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}


	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}


	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}


	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}


	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}


	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}


	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Cliente getClient() {
		return client;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Endereco)) {
			return false;
		}
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
