package com.unla.Grupo6OO22022.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unla.Grupo6OO22022.entities.Rol;
import com.unla.Grupo6OO22022.entities.UserRole;
import com.unla.Grupo6OO22022.entities.Usuario;
import com.unla.Grupo6OO22022.repositories.IUserRepository;


@Service("userService")
public class UserService implements UserDetailsService {
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.unla.Grupo6OO22022.entities.Usuario user = userRepository.findByUsernameAndFetchUserRolesEagerly(username);
		return buildUser(user, buildGrantedAuthorities(user.getUserRoles()));
	}
	
	private User buildUser(com.unla.Grupo6OO22022.entities.Usuario user, List<GrantedAuthority> grantedAuthorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(),
						true, true, true, //accountNonExpired, credentialsNonExpired, accountNonLocked,
						grantedAuthorities);
	}
	
	private List<GrantedAuthority> buildGrantedAuthorities(Set<UserRole> userRoles) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		for(UserRole userRole: userRoles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		return new ArrayList<GrantedAuthority>(grantedAuthorities);
	}
	
	
	
//	
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//		Usuario usuario = usuarioDao.findByUsername(username);		
//		return buildUser(usuario, buildGrantedAuthorities(usuario.getUserRoles));
//	}
//	
//	public Usuario buildUser(Usuario usuario,List<GrantedAuthority> grantedAuthorities) {
//		
//	}
//	
//	private List<GrantedAuthority> buildGrantedAuthorities(Set<Rol> rolesDeUsuario) {
//		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
//		for(Rol rolDeUsuario: rolesDeUsuario) {
//			grantedAuthorities.add(new SimpleGrantedAuthority(rolDeUsuario.getRol()));
//		}
//		return new ArrayList<GrantedAuthority>(grantedAuthorities);
//	}
}
