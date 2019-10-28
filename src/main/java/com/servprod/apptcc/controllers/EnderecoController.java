package com.servprod.apptcc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.servprod.apptcc.models.Endereco;
import com.servprod.apptcc.service.EnderecoService;

@RestController
@RequestMapping("api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;
    
    @PostMapping("/salvar")
    public void salvar(@RequestBody Endereco endereco){
        service.salvar(endereco);
    }

    @GetMapping
    public List<Endereco> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Endereco ListarPorId(@PathVariable("id") Long id){
        return service.listarPorId(id);
    }

    @PutMapping("/editar")
    public void editar(@RequestBody Endereco endereco){
        service.salvar(endereco);
    }

    @DeleteMapping("/deletar/{id}")
    public void excluir(@PathVariable("id") Long id){
        service.excluir(id);
    }	
}
