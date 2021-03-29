package com.springboot.app.oauth2.security.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.springboot.app.commons.usuarios.models.entity.Usuario;
import com.springboot.app.oauth2.services.IUsuarioService;

import brave.Tracer;
import feign.FeignException;

@Component
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher{

	private Logger log =  LoggerFactory.getLogger(AuthenticationSuccessErrorHandler.class);
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private Tracer tracer;

	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
	
		
		if(authentication.getName().equalsIgnoreCase("frontendapp")){
            return;
        }
		UserDetails user = (UserDetails) authentication.getPrincipal();
		String msj = "Success Login: " + user.getUsername();
		System.out.println(msj);
		log.info(msj);
		Usuario usuario =  usuarioService.findByUsername(authentication.getName());
		
		
		if(usuario.getIntentos() != null && usuario.getIntentos()> 0) {
			usuario.setIntentos(0);
			usuarioService.update(usuario, usuario.getId());
		}
		
		
	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
		String msj = "Error en el Login: " + exception.getMessage();
		System.out.println(msj);
		log.info(msj);
		
		try {
			StringBuilder errors = new StringBuilder();
			errors.append(msj);
			Usuario usuario =  usuarioService.findByUsername(authentication.getName());
			if(usuario.getIntentos() == null) {
				usuario.setIntentos(0);
				
			}
			
			log.info("Intentos actual es de: "+usuario.getIntentos());
			
			usuario.setIntentos(usuario.getIntentos()+1);
			
			log.info("Intentos despues es de: "+usuario.getIntentos());
			
			errors.append(" -- Intentos despues del login: "+usuario.getIntentos());
			
			if(usuario.getIntentos()>=3) {
				String errorMaxIntentos = String.format("El usuario %s des-habilitado por maximo de intentos" , usuario.getUsername());
				log.error(errorMaxIntentos);
				errors.append(" -- " + errorMaxIntentos);
				usuario.setEnabled(false);
			}
			usuarioService.update(usuario, usuario.getId());
			
		
			tracer.currentSpan().tag("error.mensaje", errors.toString());
			
		} catch (FeignException e) {
			String error = String.format("El usuario %s no existe en el sistema", authentication.getName());
			log.error(error);
			tracer.currentSpan().tag("error.mensaje",error);
		}
		
		
		
	}
	
	

}
