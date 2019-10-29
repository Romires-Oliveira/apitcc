package com.servprod.apptcc.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.servprod.apptcc.models.UsuarioComum;
import com.servprod.apptcc.repository.UsuarioComumRepository;
import com.servprod.apptcc.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioComumRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsuarioComum usuarioComum = repo.findByEmail(email);
        if (usuarioComum == null) {
            throw new UsernameNotFoundException(email);
        }
        return new UserSS(Integer.parseInt(usuarioComum.getId().toString()), usuarioComum.getEmail(), usuarioComum.getSenha());
	}

}
