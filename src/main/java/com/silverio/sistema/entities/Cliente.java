package com.silverio.sistema.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.Order;

@Entity // //This class is an entity mapped to a database table;
@Table(name = "tb_cliente")//  Name of the table in the database;
public class Cliente  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id //Indicates that the following field is the primary key of the entity;
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies that the  primary key generation is auto;
	
	
	private Long  n_codiclien;// The primary key of the entity;
	private String c_nomeclien;// Field to store the client's name;
    private String c_cnpjclien; // Field to store the client's CNPJ;
    private String c_foneclien; // Field to store the client's phone number;
	
    //@JsonIgnore
	//@OneToMany(mappedBy = "cliente")
	// private List<Order> orders = new ArrayList<>();
	 
    public Cliente() {	 // Default constructor			
	}
    
    

	public Cliente(Long n_codiclien, String c_nomeclien, String c_cnpjclien, String c_foneclien) {
		super();
		this.n_codiclien = n_codiclien;
		this.c_nomeclien = c_nomeclien;
		this.c_cnpjclien = c_cnpjclien;
		this.c_foneclien = c_foneclien;
	}
	
	// Getters and Setters
	public Long getN_codiclien() {
		return n_codiclien;
	}
	public void setN_codiclien(Long n_codiclien) {
		this.n_codiclien = n_codiclien;
	}
	public String getC_nomeclien() {
		return c_nomeclien;
	}
	public void setC_nomeclien(String c_nomeclien) {
		this.c_nomeclien = c_nomeclien;
	}
	public String getC_cnpjclien() {
		return c_cnpjclien;
	}
	public void setC_cnpjclien(String c_cnpjclien) {
		this.c_cnpjclien = c_cnpjclien;
	}
	public String getC_foneclien() {
		return c_foneclien;
	}
	public void setC_foneclien(String c_foneclien) {
		this.c_foneclien = c_foneclien;
	}
	
	// Overriding hashCode and equals methods for proper object comparison
	@Override
	public int hashCode() {
		return Objects.hash(n_codiclien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return n_codiclien == other.n_codiclien;
	}
    
    
}
