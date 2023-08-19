package com.silverio.sistema.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.silverio.sistema.entities.Usuario;
//This interface defines a repository for operations related to entities of type 'Usuario'.
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	//procurando produto que tem o nome 
	Optional<Usuario> findByNome(String nome);
	//procurando produto que tem o email
	Optional<Usuario> findByEmail(String email);
	Optional<Usuario> findByNomeIgnoreCase(String nome);
	
    
}

