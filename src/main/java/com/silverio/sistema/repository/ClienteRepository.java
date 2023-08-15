package com.silverio.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.silverio.sistema.entities.Cliente;



public interface ClienteRepository extends JpaRepository<Cliente,Long>{
	// This interface defines a repository for operations related to entities of type 'Cliente'.

    // 'Cliente' is the entity class associated with this repository.
    // 'Long' is the type of the primary key of the entity.

    // Spring Data JPA provides automatic implementations for various database operations.

    // For example:
    // - 'save()' method is used to save an entity to the database.
    // - 'findById()' method is used to retrieve an entity by its primary key.
    // - 'findAll()' method is used to retrieve all entities in the table.
    // - 'deleteById()' method is used to delete an entity by its primary key.
	

}

