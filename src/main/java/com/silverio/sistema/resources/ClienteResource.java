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

import com.silverio.sistema.entities.Cliente;
import com.silverio.sistema.services.ClienteService;


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
	
	@GetMapping(value = "/{n_codiclien}")
	public ResponseEntity<Cliente> findById(@PathVariable Long n_codiclien) {
		// Retrieve a client by ID using the service
		Cliente obj = service.findById(n_codiclien);
		// Return a response with the client and HTTP status OK (200)
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente obj) {
		// Insert a new client using the service
		obj = service.insert(obj);
		// Build the URI for the newly created client resource
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{n_codiclien}")
			.buildAndExpand(obj.getN_codiclien())
			.toUri();
		// Return a response with the client and HTTP status Created (201)
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{n_codiclien}")
	public ResponseEntity<Void> delete(@PathVariable Long n_codiclien) {
		// Delete a client by ID using the service
		service.delete(n_codiclien);
		// Return a response with no content and HTTP status No Content (204)
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{n_codiclien}")
	public ResponseEntity<Cliente> update(@PathVariable Long n_codiclien, @RequestBody Cliente obj) {
		// Update a client by ID using the service
		obj = service.update(n_codiclien, obj);
		// Return a response with the updated client and HTTP status OK (200)
		return ResponseEntity.ok().body(obj);
	}
}
