package com.servprod.apptcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servprod.apptcc.models.AvaliacaoSP;
import com.servprod.apptcc.repository.AvaliacaoSPRepository;

import java.util.List;

@Service
public class AvaliacaoSPService {
	
	@Autowired
    private AvaliacaoSPRepository repository;

    public List<AvaliacaoSP> listar(){
        return repository.findAll();
    }

    public void salvar(AvaliacaoSP avaliacaoSP){
        repository.save(avaliacaoSP);
    }

    public AvaliacaoSP listarPorId(Long id){
        return repository.getOne(id);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }	

}
