package com.servprod.apptcc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.servprod.apptcc.models.CategoriaSP;
import com.servprod.apptcc.service.CategoriaSPService;

@RestController
@RequestMapping("api/categoriasp")
public class CategoriaSPController {

    @Autowired
    private CategoriaSPService service;

    @PostMapping("/salvar")
    public void salvar(@RequestBody CategoriaSP categoriaSP){
        service.salvar(categoriaSP);
    }

    @GetMapping
    public List<CategoriaSP> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public CategoriaSP ListarPorId(@PathVariable("id") Long id){
        return service.listarPorId(id);
    }

    @PutMapping("/editar")
    public void editar(@RequestBody CategoriaSP categoriaSP){
        service.salvar(categoriaSP);
    }

    @DeleteMapping("/deletar/{id}")
    public void excluir(@PathVariable("id") Long id){
        service.excluir(id);
    }	
}
