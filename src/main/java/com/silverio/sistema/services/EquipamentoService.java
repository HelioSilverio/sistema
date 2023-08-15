package com.silverio.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.silverio.sistema.entities.Equipamento;
import com.silverio.sistema.repository.EquipamentoRepository;
import com.silverio.sistema.resources.execeptions.DatabaseException;
import com.silverio.sistema.services.exeptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EquipamentoService {

	@Autowired
	private EquipamentoRepository repository;
	/**
     * Retrieves a list of all clients.
     *
     * @return List of clients.
     */
	
	public List<Equipamento> findAll(){
	return repository.findAll();
	}
	/**
     * Finds a client by ID.
     *
     * @param c_codiequip The ID of the client to find.
     * @return The found client.
     * @throws ResourceNotFoundException if the client is not found.
     */
	
	public Equipamento findById(Long c_codiequip) {
		Optional<Equipamento> Obj=repository.findById(c_codiequip);
		return Obj.orElseThrow(() -> new ResourceNotFoundException (c_codiequip));
	}
	/**
     * Inserts a new client.
     *
     * @param obj The client to insert.
     * @return The inserted client.
     */
	public Equipamento insert(Equipamento obj) {
		return repository.save(obj);
	}
	/**
     * Deletes a client by ID.
     *
     * @param c_codiequip The ID of the client to delete.
     * @throws ResourceNotFoundException if the client is not found.
     * @throws DatabaseException         if a database integrity violation occurs.
     */
	public void delete (Long c_codiequip) {
		try {
		repository.deleteById(c_codiequip);
		
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException (c_codiequip) ;		
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException (e.getMessage()) ;
		}
	}
	/**
     * Updates a client by ID.
     *
     * @param c_codiequip The ID of the client to update.
     * @param obj         The updated client data.
     * @return The updated client.
     * @throws ResourceNotFoundException if the client is not found.
     */
	public Equipamento update(Long c_codiequip,Equipamento obj) {
		try {
		Equipamento entity=repository.getReferenceById(c_codiequip);
		updateData(entity,obj);		
	return repository.save(entity);
	} catch (EntityNotFoundException e) {
		throw new ResourceNotFoundException (c_codiequip) ;
	 }
	}
	/**
     * Updates the data of a client entity with new data from the provided object.
     *
     * @param entity The client entity to update.
     * @param obj    The object containing new data.
     */	
	
	
	private void updateData(Equipamento entity, Equipamento obj) {
		entity.setC_modelquip(obj.getC_modelquip());
		entity.setC_seriequip(obj.getC_seriequip());
		entity.setC_marcequip(obj.getC_marcequip());
		
		
		
	}
}