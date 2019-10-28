package com.servprod.apptcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.servprod.apptcc.models.UsuarioComum;
import com.servprod.apptcc.repository.UsuarioComumRepository;

import java.util.List;

@Service
public class UsuarioComumService {
	
	@Autowired
    private UsuarioComumRepository repository;

    public List<UsuarioComum> listar(){
        return repository.findAll();
    }

    public void salvar(UsuarioComum usuarioComum){
        repository.save(usuarioComum);
    }

    public UsuarioComum listarPorId(Long id){
        return repository.getOne(id);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }	

}
