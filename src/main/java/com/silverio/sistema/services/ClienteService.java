package com.silverio.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.silverio.sistema.entities.Cliente;
import com.silverio.sistema.repository.ClienteRepository;
import com.silverio.sistema.resources.execeptions.DatabaseException;
import com.silverio.sistema.services.exeptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	/**
     * Retrieves a list of all clients.
     *
     * @return List of clients.
     */
	
	public List<Cliente>findAll(){
	return repository.findAll();
	}
	/**
     * Finds a client by ID.
     *
     * @param n_codiclien The ID of the client to find.
     * @return The found client.
     * @throws ResourceNotFoundException if the client is not found.
     */
	
	public Cliente findById(Long n_codiclien) {
		Optional<Cliente> Obj=repository.findById(n_codiclien);
		return Obj.orElseThrow(() -> new ResourceNotFoundException (n_codiclien));
	}
	/**
     * Inserts a new client.
     *
     * @param obj The client to insert.
     * @return The inserted client.
     */
	public Cliente insert(Cliente obj) {
		return repository.save(obj);
	}
	/**
     * Deletes a client by ID.
     *
     * @param n_codiclien The ID of the client to delete.
     * @throws ResourceNotFoundException if the client is not found.
     * @throws DatabaseException         if a database integrity violation occurs.
     */
	public void delete (Long n_codiclien) {
		try {
		repository.deleteById(n_codiclien);
		
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException (n_codiclien) ;		
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
	public Cliente update(Long n_codiclien,Cliente obj) {
		try {
		Cliente entity=repository.getReferenceById(n_codiclien);
		updateData(entity,obj);		
	return repository.save(entity);
	} catch (EntityNotFoundException e) {
		throw new ResourceNotFoundException (n_codiclien) ;
	 }
	}
	/**
     * Updates the data of a client entity with new data from the provided object.
     *
     * @param entity The client entity to update.
     * @param obj    The object containing new data.
     */	
	
	
	private void updateData(Cliente entity, Cliente obj) {
		entity.setC_nomeclien(obj.getC_nomeclien());
		entity.setC_cnpjclien(obj.getC_cnpjclien());
		entity.setC_foneclien(obj.getC_foneclien());
		
		
	}
}