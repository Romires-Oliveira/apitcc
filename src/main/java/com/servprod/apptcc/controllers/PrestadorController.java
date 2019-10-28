package com.servprod.apptcc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.servprod.apptcc.models.Prestador;
import com.servprod.apptcc.service.PrestadorService;

@RestController
@RequestMapping("api/prestador")
public class PrestadorController {

    @Autowired
    private PrestadorService service;

    @PostMapping("/salvar")
    public void salvar(@RequestBody Prestador prestador){
        service.salvar(prestador);
    }

    @GetMapping
    public List<Prestador> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Prestador ListarPorId(@PathVariable("id") Long id){
        return service.listarPorId(id);
    }

    @PutMapping("/editar")
    public void editar(@RequestBody Prestador prestador){
        service.salvar(prestador);
    }

    @DeleteMapping("/deletar/{id}")
    public void excluir(@PathVariable("id") Long id){
        service.excluir(id);
    }	
}
