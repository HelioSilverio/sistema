package com.silverio.sistema.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silverio.sistema.entities.Usuario;
import com.silverio.sistema.services.UsuarioService;



@RestController // Indicates that this class is a REST controller
@RequestMapping(value = "/usuarios") // Base URL mapping for this controller
public class UsuarioResource {
	
		@Autowired//injeta dependencia
		private UsuarioService service;
		 	
		@GetMapping
		public ResponseEntity<List<Usuario>>findAll(){
			List<Usuario> list=service.findAll();
			 return ResponseEntity.ok().body(list);//resposta ok e mostra a lista
	}
		//end point para buscar usuario por id
		@GetMapping(value = "/{id}")
		public ResponseEntity<Usuario>findById(@PathVariable Long id){
			Usuario obj =service.findById(id);
			 return ResponseEntity.ok().body(obj);//resposta ok e mostra a lista
	}
		//end point para buscar usuario pelo nome
		@GetMapping(value = "/nome/{nome}")
		public ResponseEntity<Usuario>findByNome(@PathVariable String nome){
			Usuario obj =service.findByNome(nome);
			 return ResponseEntity.ok().body(obj);//resposta ok e mostra a lista
	}
		//end point para buscar usuario pelo email
				@GetMapping(value = "/email/{email}")
				public ResponseEntity<Usuario>findByEmail(@PathVariable String email){
					Usuario obj =service.findByEmail(email);
					 return ResponseEntity.ok().body(obj);//resposta ok e mostra a lista
			}
}

