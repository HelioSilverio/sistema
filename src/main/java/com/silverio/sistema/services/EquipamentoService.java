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
	public Equipamento criarEquipamento(Equipamento equipamento) {
        return repository.save(equipamento);
    }

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
	
	public Equipamento findById(Long id) {
		Optional<Equipamento> Obj=repository.findById(id);
		return Obj.orElseThrow(() -> new ResourceNotFoundException (id));
	}
	/**
     * Finds a client by Serie.        
     */
	public Equipamento findBySerie(String serie) {
		Optional<Equipamento> Obj=repository.findBySerie(serie);
		return Obj.orElseThrow(() -> new ResourceNotFoundException (serie));
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
     * @param c_codiequip The ID of the client to update.
     * @param obj         The updated client data.
     * @return The updated client.
     * @throws ResourceNotFoundException if the client is not found.
     */
	public Equipamento update(Long id,Equipamento obj) {
		try {
		Equipamento entity=repository.getReferenceById(id);
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
	
	
	private void updateData(Equipamento entity, Equipamento obj) {
		entity.setModelo(obj.getModelo());
		entity.setSerie(obj.getSerie());
		entity.setMarca(obj.getMarca());
		
		
		
	}
	
}