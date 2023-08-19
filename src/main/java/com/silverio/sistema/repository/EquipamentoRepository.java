package com.silverio.sistema.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.silverio.sistema.entities.Equipamento;
import com.silverio.sistema.entities.Usuario;


//This interface defines a repository for operations related to entities of type 'equipamento'.
public interface EquipamentoRepository extends JpaRepository<Equipamento,Long>{
	   		
		//procurando equipamento por Id; 
				Optional<Equipamento> findById(Long id);
				//procurando equipamento por serie; 
				Optional<Equipamento> findBySerie(String serie);
}

