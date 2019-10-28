package com.servprod.apptcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servprod.apptcc.models.CategoriaSP;
import com.servprod.apptcc.repository.CategoriaSPRepository;

import java.util.List;

@Service
public class CategoriaSPService {
	
	@Autowired
    private CategoriaSPRepository repository;

    public List<CategoriaSP> listar(){
        return repository.findAll();
    }

    public void salvar(CategoriaSP categoriaSP){
        repository.save(categoriaSP);
    }

    public CategoriaSP listarPorId(Long id){
        return repository.getOne(id);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }	

}
