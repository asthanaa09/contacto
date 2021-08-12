package com.contacto.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.contacto.config.AuthDetails;
import com.contacto.models.Role;
import com.contacto.models.Users;
import com.contacto.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException("Invalid username");
		
		// TODO: set account access time or save account access activity
		Set<Role> roles = user.getRoles();
		AuthDetails authDetails = new AuthDetails(user, getAuthorities(roles));
		return authDetails;
	}
	
	/**
	 * TODO: Sets roles as authority, helps to use role annotation
	 * 
	 * @param roles
	 * @return
	 */
	private Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		roles.stream().map((role) -> new SimpleGrantedAuthority(role.toString())).collect(Collectors.toSet());
		return authorities;
	}
}
