package com.servprod.apptcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servprod.apptcc.models.PessoaFisica;
import com.servprod.apptcc.repository.PessoaFisicaRepository;

import java.util.List;

@Service
public class PessoaFisicaService {
	
	@Autowired
    private PessoaFisicaRepository repository;

    public List<PessoaFisica> listar(){
        return repository.findAll();
    }

    public void salvar(PessoaFisica pessoaFisica){
        repository.save(pessoaFisica);
    }

    public PessoaFisica listarPorId(Long id){
        return repository.getOne(id);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }	

}
