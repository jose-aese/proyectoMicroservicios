package com.springboot.app.usuarios.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.springboot.app.commons.usuarios.models.entity.Usuario;








@RepositoryRestResource(path="usuarios")
public interface UsuarioDao extends PagingAndSortingRepository<Usuario,Long>{	

	//public Usuario findByUsernameAndEmail(String username, String email);
	@RestResource(path = "busca-username")
	public Usuario findByUsername(@Param("username") String username);
	
	// La consulta es a nivel del entity, mas no a la tabla de la BD
	@Query("select u from Usuario u where u.username=?1")
	public Usuario obtenerPorUsername(String username);
}
