package com.silverio.sistema.resources.execeptions;

import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.silverio.sistema.services.exeptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Global exception handler for handling specific exceptions and providing standardized error responses.
 */
	@ControllerAdvice
	public class ResourceExceptionHandler {
		/**
	     * Exception handler for handling ResourceNotFoundException.
	     *
	     * @param e       The ResourceNotFoundException instance.
	     * @param request The HttpServletRequest.
	     * @return A ResponseEntity containing a standardized error response.
	     */
		
		@ExceptionHandler(ResourceNotFoundException.class)
		public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e,HttpServletRequest request){
		String error ="Objeto nao encontrado";
		HttpStatus status= HttpStatus.NOT_FOUND;
		StandardError err =new StandardError(Instant.now(),status.value(), error,e.getMessage(),request.getRequestURI());
			return ResponseEntity.status(status).body(err);
			
		}
		
		/**
	     * Exception handler for handling DatabaseException.
	     *
	     * @param e       The DatabaseException instance.
	     * @param request The HttpServletRequest.
	     * @return A ResponseEntity containing a standardized error response.
	     */
		@ExceptionHandler(DatabaseException .class)
		public ResponseEntity<StandardError> database (DatabaseException  e,HttpServletRequest request){
		String error ="Data Base Error";
		HttpStatus status= HttpStatus.BAD_REQUEST;
		StandardError err =new StandardError(Instant.now(),status.value(), error,e.getMessage(),request.getRequestURI());
			return ResponseEntity.status(status).body(err);
			
		}
		
		
	}
