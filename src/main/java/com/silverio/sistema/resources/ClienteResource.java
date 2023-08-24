package com.silverio.sistema.resources;
	
import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.silverio.sistema.entities.Cliente;
import com.silverio.sistema.entities.Equipamento;
import com.silverio.sistema.repository.ClienteRepository;
import com.silverio.sistema.services.ClienteService;
import com.silverio.sistema.services.EquipamentoService;

@RestController // Indicates that this class is a REST controller
@RequestMapping(value = "/clientes") // Base URL mapping for this controller
public class ClienteResource {
	
	@Autowired
	private ClienteService service; // Injecting the ClienteService dependency
	  
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		// Retrieve the list of all clients using the service
		List<Cliente> list = service.findAll();
		// Return a response with the list of clients and HTTP status OK (200)
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		// Retrieve a client by ID using the service
		Cliente obj = service.findById(id);
		// Return a response with the client and HTTP status OK (200)
		return ResponseEntity.ok().body(obj);
	}
	//end point para buscar equipamento por serie;
	@GetMapping(value = "nome/{nome}")
	public ResponseEntity<Cliente> findByNome(@PathVariable String nome) {
		// Retrieve a client by ID using the service
		Cliente obj = service.findByNome(nome);
		// Return a response with the client and HTTP status OK (200)
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping(value = "cnpj/{cnpj}")
	public ResponseEntity<Cliente> findByCnpj(@PathVariable String cnpj) {
		// Retrieve a client by ID using the service
		Cliente obj = service.findByCnpj(cnpj);
		// Return a response with the client and HTTP status OK (200)
		return ResponseEntity.ok().body(obj);
	}
}
			

