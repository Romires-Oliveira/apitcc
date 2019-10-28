package com.servprod.apptcc.repository;

import com.servprod.apptcc.models.CategoriaSP;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaSPRepository extends JpaRepository<CategoriaSP, Long> {

}
