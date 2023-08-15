package com.silverio.sistema.resources;
	import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.silverio.sistema.entities.Equipamento;
import com.silverio.sistema.services.EquipamentoService;


@RestController // Indicates that this class is a REST controller
@RequestMapping(value = "/equipamentos") // Base URL mapping for this controller
public class EquipamentoResource {
	
	@Autowired
	private EquipamentoService service; // Injecting the ClienteService dependency
	
	@GetMapping
	public ResponseEntity<List<Equipamento>> findAll() {
		// Retrieve the list of all clients using the service
		List<Equipamento> list = service.findAll();
		// Return a response with the list of clients and HTTP status OK (200)
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{c_codiequip}")
	public ResponseEntity<Equipamento> findById(@PathVariable Long c_codiequip) {
		// Retrieve a client by ID using the service
		Equipamento obj = service.findById(c_codiequip);
		// Return a response with the client and HTTP status OK (200)
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Equipamento> insert(@RequestBody Equipamento obj) {
		// Insert a new client using the service
		obj = service.insert(obj);
		// Build the URI for the newly created client resource
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{c_codiequip}")
			.buildAndExpand(obj.getC_codiequip())
			.toUri();
		// Return a response with the client and HTTP status Created (201)
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{c_codiequip}")
	public ResponseEntity<Void> delete(@PathVariable Long c_codiequip) {
		// Delete a client by ID using the service
		service.delete(c_codiequip);
		// Return a response with no content and HTTP status No Content (204)
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{c_codiequip}")
	public ResponseEntity<Equipamento> update(@PathVariable Long c_codiequip, @RequestBody Equipamento obj) {
		// Update a client by ID using the service
		obj = service.update(c_codiequip, obj);
		// Return a response with the updated client and HTTP status OK (200)
		return ResponseEntity.ok().body(obj);
	}
}
