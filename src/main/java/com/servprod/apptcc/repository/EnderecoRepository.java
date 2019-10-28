package com.servprod.apptcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servprod.apptcc.models.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
