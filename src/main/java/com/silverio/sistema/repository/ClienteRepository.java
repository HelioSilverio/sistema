package com.silverio.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.silverio.sistema.entities.Cliente;



public interface ClienteRepository extends JpaRepository<Cliente,Long>{
	
	

}

