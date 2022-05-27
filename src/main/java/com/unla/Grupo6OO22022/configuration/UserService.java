package com.unla.Grupo6OO22022.configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unla.Grupo6OO22022.entities.Rol;
import com.unla.Grupo6OO22022.entities.Usuario;


@Service("userService")
public class UserService implements UserDetailsService {
	@Autowired
	private IUsuarioDao usuario;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Usuario usuario = usuarioDao.findByUsername(username);		
		return buildUser(usuario, buildGrantedAuthorities(usuario.getUserRoles));
	}
	
	public Usuario buildUser(Usuario usuario,List<GrantedAuthority> grantedAuthorities) {
		
	}
	
	private List<GrantedAuthority> buildGrantedAuthorities(Set<Rol> rolesDeUsuario) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		for(Rol rolDeUsuario: rolesDeUsuario) {
			grantedAuthorities.add(new SimpleGrantedAuthority(rolDeUsuario.getRol()));
		}
		return new ArrayList<GrantedAuthority>(grantedAuthorities);
	}
}
