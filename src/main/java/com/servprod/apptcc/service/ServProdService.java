package com.servprod.apptcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servprod.apptcc.models.ServProd;
import com.servprod.apptcc.repository.ServProdRepository;

import java.util.List;

@Service
public class ServProdService {
	
	@Autowired
    private ServProdRepository repository;

    public List<ServProd> listar(){
        return repository.findAll();
    }

    public void salvar(ServProd servProd){
        repository.save(servProd);
    }

    public ServProd listarPorId(Long id){
        return repository.getOne(id);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }	

}
