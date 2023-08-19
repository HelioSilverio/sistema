package com.silverio.sistema.resources;
	
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silverio.sistema.entities.Cliente;
import com.silverio.sistema.services.ClienteService;



@RestController // Indicates that this class is a REST controller
@RequestMapping(value = "/clientes") // Base URL mapping for this controller
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	 	
	@GetMapping
	public ResponseEntity<List<Cliente>>findAll(){
		List<Cliente> list=service.findAll();
		 return ResponseEntity.ok().body(list);
}
	//end point para buscar usuario por id
			@GetMapping(value = "/{id}")
			public ResponseEntity<Cliente>findById(@PathVariable Long id){
				Cliente obj =service.findById(id);
				 return ResponseEntity.ok().body(obj);//resposta ok e mostra a lista
		}
			//end point para buscar usuario pelo nome
			@GetMapping(value = "/nome/{nome}")
			public ResponseEntity<Cliente>findByNome(@PathVariable String nome){
				Cliente obj =service.findByNome(nome);
				 return ResponseEntity.ok().body(obj);//resposta ok e mostra a lista
	
}
}