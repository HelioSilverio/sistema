package com.silverio.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.silverio.sistema.entities.Usuario;
import com.silverio.sistema.repository.UsuarioRepository;
import com.silverio.sistema.resources.execeptions.DatabaseException;
import com.silverio.sistema.services.exeptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {
		
		@Autowired//injeta depencia do controlador
		private UsuarioRepository repository;//dependencia para usuarioRepository
		
		//retorna todos usuarios do banco de dados
		//operacao na camada de servico que repassa para o repositry atrves do findall;
		public List<Usuario>findAll(){
		return repository.findAll();
		}
		
		//busca usuario por id
		public Usuario findById(Long id) {
			Optional<Usuario> Obj=repository.findById(id);
			return Obj.orElseThrow(() -> new ResourceNotFoundException (id));
		}
		//busca usuario por nome
		// This method should find a user by name
	    public Usuario findByNome(String nome) {
	        Optional<Usuario> obj = repository.findByNomeIgnoreCase(nome); // Corrected parameter name

	        if (obj.isPresent()) {
	            return obj.get();
	        } else {
	            throw new ResourceNotFoundException("Usuário com nome " + nome + " não encontrado.");
	        }
	    }
				    
			        
			    
 
				//busca usuario por email
				public Usuario findByEmail(String email) {
					Optional<Usuario> Obj=repository.findByEmail(email);
					return Obj.orElseThrow(() -> new ResourceNotFoundException ( "Usuário com e-mail " + email + " não encontrado."));
				
				}
		
		
		public Usuario insert(Usuario obj) {
			return repository.save(obj);
		}
		public void delete (Long id) {
			try {
			repository.deleteById(id);
			
			}catch (EmptyResultDataAccessException e) {
				throw new ResourceNotFoundException (id) ;		
			}catch (DataIntegrityViolationException e) {
				throw new DatabaseException (e.getMessage()) ;
			}
		}
		
		public Usuario update(Long id,Usuario obj) {
			try {
			Usuario entity=repository.getReferenceById(id);
			updateData(entity,obj);		
		return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException (id) ;
		 }
		}
				
		
		
		private void updateData(Usuario entity, Usuario obj) {
			entity.setNome(obj.getNome());
			entity.setEmail(obj.getEmail());
			entity.setFone(obj.getFone());
			entity.setFone(obj.getPassword());
			
		}
	}


