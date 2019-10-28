package com.servprod.apptcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servprod.apptcc.models.Prestador;
import com.servprod.apptcc.repository.PrestadorRepository;

import java.util.List;

@Service
public class PrestadorService {
	
	@Autowired
    private PrestadorRepository repository;

    public List<Prestador> listar(){
        return repository.findAll();
    }

    public void salvar(Prestador prestador){
        repository.save(prestador);
    }

    public Prestador listarPorId(Long id){
        return repository.getOne(id);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }	

}
