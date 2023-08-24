package com.silverio.sistema.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.silverio.sistema.entities.Cliente;
import com.silverio.sistema.entities.Endereco;
import com.silverio.sistema.entities.Usuario;



//This interface defines a repository for operations related to entities of type 'Cliente'.
public interface EnderecoRepository extends JpaRepository<Endereco,Long>{
	       
	
	//procurando produto que tem o nome 
		
		Optional<Endereco> findByRuaIgnoreCase(String rua);
		

}

