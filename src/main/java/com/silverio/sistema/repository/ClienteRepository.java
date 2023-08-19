package com.silverio.sistema.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.silverio.sistema.entities.Cliente;
import com.silverio.sistema.entities.Usuario;



//This interface defines a repository for operations related to entities of type 'Cliente'.
public interface ClienteRepository extends JpaRepository<Cliente,Long>{
	       
	
	//procurando produto que tem o nome 
		Optional<Cliente> findByNome(String nome);
		//procurando produto que tem o email
		//Optional<Cliente> findByEmail(String email);
		Optional<Cliente> findByNomeIgnoreCase(String nome);
		

}

