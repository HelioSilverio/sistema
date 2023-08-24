package com.silverio.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.silverio.sistema.entities.Endereco;
import com.silverio.sistema.entities.Usuario;
import com.silverio.sistema.repository.ClienteRepository;
import com.silverio.sistema.repository.EnderecoRepository;
import com.silverio.sistema.resources.execeptions.DatabaseException;
import com.silverio.sistema.services.exeptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;
	
     //*    * Retrieves a list of all clients.   */
	public List<Endereco>findAll(){
	return repository.findAll();
	}
	
	/*** Finds a client by ID.   */
		public Endereco findById(Long id) {
		Optional<Endereco> Obj=repository.findById(id);
		return Obj.orElseThrow(() -> new ResourceNotFoundException (id));
	}
				
	/**
     * Finds a client by Name.
         */
		//busca usuario por nome
				// This method should find a user by name
			//    public Endereco findByNome(String rua) {
			    //    Optional<Endereco> obj = repository.findByRuaIgnoreCase(rua); // Corrected parameter name

			    //    if (obj.isPresent()) {
			       //     return obj.get();
			     //   } else {
			       //     throw new ResourceNotFoundException("Endereco com nome " + rua + " não encontrado.");
			    //    }
			//    }	
			
	
	public Endereco criarCliente(Endereco cliente) {
        return repository.save(cliente);
    }
	/**
     * Inserts a new client.
        
     */
	public Endereco insert(Endereco obj) {
		return repository.save(obj);
	}
	/**
     * Deletes a client by ID.
     *
     * @param n_codiclien The ID of the client to delete.
     * @throws ResourceNotFoundException if the client is not found.
     * @throws DatabaseException         if a database integrity violation occurs.
     */
	public void delete (Long id) {
		try {
		repository.deleteById(id);
		
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException (id) ;		
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException (e.getMessage()) ;
		}
	}
	/**
     * Updates a client by ID.
     *
     * @param n_codiclien The ID of the client to update.
     * @param obj         The updated client data.
     * @return The updated client.
     * @throws ResourceNotFoundException if the client is not found.
     */
	public Endereco update(Long id,Endereco obj) {
		try {		Endereco entity=repository.getReferenceById(id);
		updateData(entity,obj);		
	return repository.save(entity);
	} catch (EntityNotFoundException e) {
		throw new ResourceNotFoundException (id) ;
	 }
	}
	/**
     * Updates the data of a client entity with new data from the provided object.
     *
     * @param entity The client entity to update.
     * @param obj    The object containing new data.
     */	
	
	
	private void updateData(Endereco entity, Endereco obj) {
		entity.setCep(obj.getCep());
		entity.setRua(obj.getRua());
		entity.setNumero(obj.getNumero());
		entity.setBairro(obj.getBairro());
		entity.setCidade(obj.getCidade());
		entity.setEstado(obj.getEstado());
		//entity.setBairro(obj.getBairro());
		
		
	}
	

	
	
	
}