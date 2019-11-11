package com.servprod.apptcc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.servprod.apptcc.models.AvaliacaoSP;
import com.servprod.apptcc.service.AvaliacaoSPService;

@RestController
@RequestMapping("api/avaliacaosp")
public class AvaliacaoSPController {

    @Autowired
    private AvaliacaoSPService service;

    @PostMapping("/salvar")
    public void salvar(@RequestBody AvaliacaoSP avaliacaoSP){
        service.salvar(avaliacaoSP);
    }

    @GetMapping
    public List<AvaliacaoSP> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public AvaliacaoSP ListarPorId(@PathVariable("id") Long id){
        return service.listarPorId(id);
    }

    @PutMapping("/editar")
    public void editar(@RequestBody AvaliacaoSP avaliacaoSP){
        service.salvar(avaliacaoSP);
    }

    @DeleteMapping("/deletar/{id}")
    public void excluir(@PathVariable("id") Long id){
        service.excluir(id);
    }	
}
