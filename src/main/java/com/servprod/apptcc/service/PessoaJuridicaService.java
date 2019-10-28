package com.servprod.apptcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servprod.apptcc.models.PessoaJuridica;
import com.servprod.apptcc.repository.PessoaJuridicaRepository;

import java.util.List;

@Service
public class PessoaJuridicaService {
	
	@Autowired
    private PessoaJuridicaRepository repository;

    public List<PessoaJuridica> listar(){
        return repository.findAll();
    }

    public void salvar(PessoaJuridica pessoaJuridica){
        repository.save(pessoaJuridica);
    }

    public PessoaJuridica listarPorId(Long id){
        return repository.getOne(id);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }	

}
