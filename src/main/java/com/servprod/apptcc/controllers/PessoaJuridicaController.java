package com.servprod.apptcc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.servprod.apptcc.models.PessoaJuridica;
import com.servprod.apptcc.service.PessoaJuridicaService;

@RestController
@RequestMapping("api/pessoajuridica")
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaService service;

    @PostMapping("/salvar")
    public void salvar(@RequestBody PessoaJuridica pessoaJuridica){
        service.salvar(pessoaJuridica);
    }

    @GetMapping
    public List<PessoaJuridica> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public PessoaJuridica ListarPorId(@PathVariable("id") Long id){
        return service.listarPorId(id);
    }

    @PutMapping("/editar")
    public void editar(@RequestBody PessoaJuridica pessoaJuridica){
        service.salvar(pessoaJuridica);
    }

    @DeleteMapping("/deletar/{id}")
    public void excluir(@PathVariable("id") Long id){
        service.excluir(id);
    }	
}
