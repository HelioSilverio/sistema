package com.silverio.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.silverio.sistema.entities.Contador;

public interface ContadorRepository extends JpaRepository<Contador,Long>{
	
	

}