package com.silverio.sistema.resources;
	import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.silverio.sistema.entities.Usuario;
import com.silverio.sistema.repository.EquipamentoRepository;
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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Equipamento> findById(@PathVariable Long id) {
		// Retrieve a client by ID using the service
		Equipamento obj = service.findById(id);
		// Return a response with the client and HTTP status OK (200)
		return ResponseEntity.ok().body(obj);
	}
	//end point para buscar equipamento por serie;
			@GetMapping(value = "/serie/{serie}")
			public ResponseEntity<Equipamento>findBySerie(@PathVariable String serie){
				Equipamento obj =service.findBySerie(serie);
				 return ResponseEntity.ok().body(obj);//resposta ok e mostra a lista
		}
	
//@PostMapping
//	public ResponseEntity<Equipamento> insert(@RequestBody Equipamento obj) {
		// Insert a new client using the service
		//obj = service.insert(obj);
		// Build the URI for the newly created client resource
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			//.path("/{id}")
		//	.buildAndExpand(obj.getId())
			//.toUri();
		// Return a response with the client and HTTP status Created (201)
		//return ResponseEntity.created(uri).body(obj);
	//}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		// Delete a client by ID using the service
		service.delete(id);
		// Return a response with no content and HTTP status No Content (204)
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Equipamento> update(@PathVariable Long id, @RequestBody Equipamento obj) {
		// Update a client by ID using the service
		obj = service.update(id, obj);
		// Return a response with the updated client and HTTP status OK (200)
		return ResponseEntity.ok().body(obj);
	}
}
