package com.silverio.sistema.services.exeptions;

public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
 public ResourceNotFoundException (Object n_codiclien) {
	 super("Recurso nao encontrado.Id"+ n_codiclien);
	 
 }
 
  
 
    
}