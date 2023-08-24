package com.silverio.sistema.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silverio.sistema.entities.Usuario;
import com.silverio.sistema.repository.UsuarioRepository;
import com.silverio.sistema.services.exeptions.ResourceNotFoundException;



@Service //Registra acmada como sercie
public class UsuarioService {
		
		@Autowired//injeta depencia do controlador
		private UsuarioRepository repository;//dependencia para usuarioRepository
		
		//retorna todos usuarios do banco de dados
		public List<Usuario>findAll(){
		return repository.findAll();
		}
		//busca um  usuario por id
		public Usuario findById(Long id) {
			Optional<Usuario> Obj=repository.findById(id);
			return Obj.orElseThrow(() -> new ResourceNotFoundException (id));
		}
		// This method should find a user by name
			public Usuario findByNome(String nome) {
				Optional<Usuario> Obj=repository.findByNome(nome);
				return Obj.orElseThrow(() -> new ResourceNotFoundException (nome));
			}

			/*	// This method should find a user by name
					public Usuario findBycpf(String cpf) {
						Optional<Usuario> Obj=repository.findByCpf(cpf);
						return Obj.orElseThrow(() -> new ResourceNotFoundException (cpf));
			}*/
// This method should find a user by email
					public Usuario findByEmail(String email) {
						Optional<Usuario> Obj=repository.findByEmail(email);
						return Obj.orElseThrow(() -> new ResourceNotFoundException (email));
						
					}
	}


