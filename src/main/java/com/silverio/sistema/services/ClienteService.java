package com.silverio.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.silverio.sistema.entities.Cliente;
import com.silverio.sistema.entities.Equipamento;
import com.silverio.sistema.entities.Usuario;
import com.silverio.sistema.repository.ClienteRepository;
import com.silverio.sistema.resources.execeptions.DatabaseException;
import com.silverio.sistema.services.exeptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
@Transactional
@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
     //*    * Retrieves a list of all clients.   */
	public List<Cliente>findAll(){
	return repository.findAll();
	}
	
	/*** Finds a client by ID.   */
		public Cliente findById(Long id) {
		Optional<Cliente> Obj=repository.findById(id);
		return Obj.orElseThrow(() -> new ResourceNotFoundException (id));
	}
	/**
     * Finds a client by Name.
         */
		
		public Cliente findByNome(String nome) {
			Optional<Cliente> Obj=repository.findByNome(nome);
			return Obj.orElseThrow(() -> new ResourceNotFoundException (nome));
		}
		
		public Cliente findByCnpj(String cnpj) {
			Optional<Cliente> Obj=repository.findByCnpj(cnpj);
			return Obj.orElseThrow(() -> new ResourceNotFoundException (cnpj));
		}
		/**
     * Inserts a new client.
        
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
	public Cliente update(Long id,Cliente obj) {
		try {		Cliente entity=repository.getReferenceById(id);
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
	
	
	private void updateData(Cliente entity, Cliente obj) {
		entity.setNome(obj.getNome());
		entity.setCnpj(obj.getCnpj());
		entity.setTelefone(obj.getTelefone());
		
		
	}
	//public Cliente buscarClienteComEquipamentos(Long clienteId) {
		// TODO Auto-generated method stub
	///	return null;
	//}
	//public Cliente buscarClienteComEnderecos(Long clienteId) {
		// TODO Auto-generated method stub
		//return null;
	//}

	public Cliente findByTelefone(String telefone) {
		// TODO Auto-generated method stub
		return null;
	}

	
}