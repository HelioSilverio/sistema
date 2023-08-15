package com.silverio.sistema.services.exeptions;

public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
  public ResourceNotFoundException (Object n_codiclien) {
	  super("Resource not found.Id"+ n_codiclien);
	  
  }
}
