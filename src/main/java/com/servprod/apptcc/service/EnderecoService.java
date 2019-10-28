package com.servprod.apptcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servprod.apptcc.models.Endereco;
import com.servprod.apptcc.repository.EnderecoRepository;

import java.util.List;

@Service
public class EnderecoService {
	
	@Autowired
    private EnderecoRepository repository;

    public List<Endereco> listar(){
        return repository.findAll();
    }

    public void salvar(Endereco endereco){
        repository.save(endereco);
    }

    public Endereco listarPorId(Long id){
        return repository.getOne(id);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }	

}
