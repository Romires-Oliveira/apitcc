package com.servprod.apptcc.repository;

import com.servprod.apptcc.models.ServProd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServProdRepository extends JpaRepository<ServProd, Long> {

}
