package com.silverio.sistema.resources;
	
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silverio.sistema.entities.Endereco;
import com.silverio.sistema.services.ClienteService;
import com.silverio.sistema.services.EnderecoService;



@RestController // Indicates that this class is a REST controller
@RequestMapping(value = "/enderecos") // Base URL mapping for this controller
public class EnderecoResource {
	
	@Autowired
	private EnderecoService service;
	 	
	@GetMapping
	public ResponseEntity<List<Endereco>>findAll(){
		List<Endereco> list=service.findAll();
		 return ResponseEntity.ok().body(list);
}
	//end point para buscar usuario por id
			@GetMapping(value = "/{id}")
			public ResponseEntity<Endereco>findById(@PathVariable Long id){
				Endereco obj =service.findById(id);
				 return ResponseEntity.ok().body(obj);//resposta ok e mostra a lista
		}
			//end point para buscar usuario pelo nome
			

}