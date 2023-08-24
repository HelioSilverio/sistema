package com.silverio.sistema.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.silverio.sistema.entities.Cliente;
import com.silverio.sistema.entities.Equipamento;




//This interface defines a repository for operations related to entities of type 'Cliente'.
public interface ClienteRepository extends JpaRepository<Cliente,Long>{

	Optional<Cliente> findByNome(String nome);
	Optional<Cliente> findByCnpj(String cnpj); 
	Optional<Cliente> findById(Long Id);
	//procurando produto que tem o nome 
	
		//procurando produto que tem o email
		//Optional<Cliente> findByEmail(String email);
	
		

}

