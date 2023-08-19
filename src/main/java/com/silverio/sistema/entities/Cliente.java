package com.silverio.sistema.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // //This class is an entity mapped to a database table;
@Table(name = "tb_cliente")//  Name of the table in the database;
public class Cliente  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id //Indicates that the following field is the primary key of the entity;
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies that the  primary key generation is auto;
	@Column(name = "n_numeclien")
	
	private Long  id;// The primary key of the entity;
	
	@Column(name = "c_nomeclien")
	private String nome;// Field to store the client's name;
	
	@Column(name = "c_cnpjclien")
    private String cnpj; // Field to store the client's CNPJ;
	
	@Column(name = "c_foneclien")
	private String telefone; // Field to store the client's phone number;
			    
    
    @OneToMany(mappedBy = "cliente")
       private List<Equipamento> equipamentos=new ArrayList<>();
   
     	public Cliente() {	 // Default constructor			
	}
      	
	public Cliente(Long id, String nome, String cnpj, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.telefone = telefone;
	
		
	}

	// Getters and Setters
					
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


	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	//lista ou coleçao adicionar somente get
	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}
	
	// Overriding hashCode and equals methods for proper object comparison
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
		Cliente other = (Cliente) obj;
		if(id==null) {
			if(other.id !=null)
				return false;
			
		}else if(!id.equals(other.id))
			return false;
		return true;
	}

	
    
    
}
