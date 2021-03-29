package com.springboot.app.oauth2.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.springboot.app.commons.usuarios.models.entity.Usuario;
import com.springboot.app.oauth2.services.IUsuarioService;

@Component
public class InfoAdicionalToken  implements TokenEnhancer{

	
	@Autowired
	private IUsuarioService usuarioService;
	
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		final Map<String, Object> additionalInfo = new HashMap<>();
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		
		additionalInfo.put("nombre", usuario.getNombre());
		additionalInfo.put("apellido", usuario.getApellido());
		additionalInfo.put("correo", usuario.getEmail());
		 ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
	     return accessToken;
	}

}
