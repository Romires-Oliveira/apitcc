package com.servprod.apptcc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.servprod.apptcc.models.ServProd;
import com.servprod.apptcc.service.ServProdService;

@RestController
@RequestMapping("api/servprod")
public class ServProdController {

    @Autowired
    private ServProdService service;

    @PostMapping("/salvar")
    public void salvar(@RequestBody ServProd servProd){
        service.salvar(servProd);
    }

    @GetMapping
    public List<ServProd> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public ServProd ListarPorId(@PathVariable("id") Long id){
        return service.listarPorId(id);
    }

    @PutMapping("/editar")
    public void editar(@RequestBody ServProd servProd){
        service.salvar(servProd);
    }

    @DeleteMapping("/deletar/{id}")
    public void excluir(@PathVariable("id") Long id){
        service.excluir(id);
    }	
}
