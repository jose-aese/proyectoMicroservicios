package com.springboot.app.oauth2.services;

import com.springboot.app.commons.usuarios.models.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
	
	
	public Usuario update (Usuario usuario, Long id); 
}
