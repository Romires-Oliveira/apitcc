package com.servprod.apptcc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.servprod.apptcc.models.PessoaFisica;
import com.servprod.apptcc.service.PessoaFisicaService;

@RestController
@RequestMapping("api/pessoafisica")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService service;

    @PostMapping("/salvar")
    public void salvar(@RequestBody PessoaFisica pessoaFisica){
        service.salvar(pessoaFisica);
    }

    @GetMapping
    public List<PessoaFisica> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public PessoaFisica ListarPorId(@PathVariable("id") Long id){
        return service.listarPorId(id);
    }

    @PutMapping("/editar")
    public void editar(@RequestBody PessoaFisica pessoaFisica){
        service.salvar(pessoaFisica);
    }

    @DeleteMapping("/deletar/{id}")
    public void excluir(@PathVariable("id") Long id){
        service.excluir(id);
    }	
}
