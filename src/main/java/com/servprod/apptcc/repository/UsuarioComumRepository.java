package com.servprod.apptcc.repository;

import com.servprod.apptcc.models.UsuarioComum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioComumRepository extends JpaRepository<UsuarioComum, Long> {
	
	UsuarioComum findByEmail (String email);

}
