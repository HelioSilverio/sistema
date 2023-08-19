package com.silverio.sistema.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.silverio.sistema.entities.Usuario;
import com.silverio.sistema.entities.Cliente;
import com.silverio.sistema.entities.Equipamento;
import com.silverio.sistema.repository.ClienteRepository;
import com.silverio.sistema.repository.EquipamentoRepository;
import com.silverio.sistema.repository.UsuarioRepository;


@Configuration // Indicates that this class provides Spring configuration
@Profile("dev") // Specifies that this configuration is for the "dev" profile
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;// Injecting the ClienteRepository dependency

	@Autowired
	private ClienteRepository clienteRepository;// Injecting the ClienteRepository dependency

	@Autowired
	private EquipamentoRepository equipamentoRepository;// Injecting the ClienteRepository dependency
	
			
	
	@Override
	public void run(String... args) throws Exception {
		
		// Creating instances of Usuario for tests;
				Usuario  usuario_1 = new Usuario(null, "Maria Brown", "e@ga.com.br", "31 99051307","1234567");
				Usuario  usuario_2 = new Usuario(null, "Mr Brown", "f@ga.com.br", "31 99051307","1234567");
				// Save the instances to the repository;
				usuarioRepository.saveAll(Arrays.asList(usuario_1,usuario_2));
		
		
		// Creating instances of Cliente for tests;
		Cliente cliente_1 = new Cliente(null, " Brown", "05388370695", "31 99051307");
		Cliente cliente_2 = new Cliente(null, "Alex ",  "02788370695", "31 99995875"); 
		Cliente cliente_3 = new Cliente(null, "Maria ", "0388370695", "31 99051307");
		Cliente cliente_4 = new Cliente(null, "Alex ",  "02788370695", "31 99995875"); 
		// Save the instances to the repository;
		clienteRepository.saveAll(Arrays.asList(cliente_1,cliente_2,cliente_3,cliente_4));
		
		// Creating instances of Equipamento for tests;
		Equipamento equip_1 = new Equipamento(null, "IpRC-700", "JPR-4747","Canon",cliente_2); 
		Equipamento equip_2 = new Equipamento(null, "IPRc800", "JPR-6567","Canon",cliente_1); 
		Equipamento equip_3 = new Equipamento(null, "IPRc800", "JPR-6967","Canon",cliente_2); 
		Equipamento equip_4 = new Equipamento(null, "IPRc800", "JPR-6867","Canon",cliente_2); 
		// Save the instances to the repository;
		equipamentoRepository.saveAll(Arrays.asList(equip_1,equip_2,equip_3,equip_4));
		
				
	}
		
	}


