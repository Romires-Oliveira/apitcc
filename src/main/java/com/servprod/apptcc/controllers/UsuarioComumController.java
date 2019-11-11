package com.servprod.apptcc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.servprod.apptcc.models.UsuarioComum;
import com.servprod.apptcc.service.UsuarioComumService;

@RestController
@RequestMapping("api/usuariocomum")
public class UsuarioComumController {

    @Autowired
    private UsuarioComumService service;

    @PostMapping("/salvar")
    public void salvar(@RequestBody UsuarioComum usuarioComum){
        service.salvar(usuarioComum);
    }

    @GetMapping()
    public List<UsuarioComum> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public UsuarioComum ListarPorId(@PathVariable("id") Long id){
        return service.listarPorId(id);
    }

    @PutMapping("/editar")
    public void editar(@RequestBody UsuarioComum usuarioComum){
        service.salvar(usuarioComum);
    }

    @DeleteMapping("/deletar/{id}")
    public void excluir(@PathVariable("id") Long id){
        service.excluir(id);
    }	
}
