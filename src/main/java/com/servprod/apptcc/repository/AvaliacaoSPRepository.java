package com.servprod.apptcc.repository;

import com.servprod.apptcc.models.AvaliacaoSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoSPRepository extends JpaRepository<AvaliacaoSP, Long> {

}
