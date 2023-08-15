package com.silverio.sistema.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.silverio.sistema.entities.Cliente;
import com.silverio.sistema.entities.Equipamento;
import com.silverio.sistema.repository.ClienteRepository;
import com.silverio.sistema.repository.EquipamentoRepository;


@Configuration // Indicates that this class provides Spring configuration
@Profile("dev") // Specifies that this configuration is for the "dev" profile
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ClienteRepository clienteRepository;// Injecting the ClienteRepository dependency

	@Autowired
	private EquipamentoRepository equipamentoRepository;// Injecting the ClienteRepository dependency
	
	@Override
	public void run(String... args) throws Exception {
		// Creating instances of Cliente for tests;
		Cliente cliente_1 = new Cliente(null, "Maria Brown", "02788370695", "31 99051307");
		Cliente cliente_2 = new Cliente(null, "Alex Green",  "02788370695", "31 99995875"); 
		
		// Save the instances to the repository;
		clienteRepository.saveAll(Arrays.asList(cliente_1,cliente_2));
		
		// Creating instances of Equipamento for tests;
		Equipamento equip_1 = new Equipamento(null, "IpRC-700", "JPR-4747","Canon"); 
		Equipamento equip_2 = new Equipamento(null, "IPRc800", "JPR-6767","Canon"); 
		
		// Save the instances to the repository;
				equipamentoRepository.saveAll(Arrays.asList(equip_1,equip_2));
	}
		
	}


