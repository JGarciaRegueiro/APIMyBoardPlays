package com.myboardplays.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myboardplays.entities.Usuario;
import com.myboardplays.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository urepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = urepo
			.findByEmail(email)
			.orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));
		
		return new UserDetailsImpl(usuario);
		
	}
}
