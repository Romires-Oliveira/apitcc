package com.servprod.apptcc.repository;

import com.servprod.apptcc.models.UsuarioComum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuarioComumRepository extends JpaRepository<UsuarioComum, Long> {
	
        @Transactional(readOnly = true)
	UsuarioComum findByEmail (String email);

}
