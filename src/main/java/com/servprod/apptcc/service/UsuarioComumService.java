package com.servprod.apptcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.servprod.apptcc.models.UsuarioComum;
import com.servprod.apptcc.repository.UsuarioComumRepository;

import java.util.List;

@Service
public class UsuarioComumService {
	
	@Autowired
    private UsuarioComumRepository repository;
	
    @Autowired
    private BCryptPasswordEncoder pe;

    public List<UsuarioComum> listar(){
        return repository.findAll();
    }

    public void salvar(UsuarioComum usuarioComum){
    	usuarioComum.setSenha(pe.encode(usuarioComum.getSenha()));
        repository.save(usuarioComum);
    }

    public UsuarioComum listarPorId(Long id){
        return repository.getOne(id);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }	

    public void listarPorEmail (String email) {
    	repository.findByEmail(email);
    }
    
    public Boolean alterarSenha(UsuarioComum usuarioComum, String senhaAtual, String novaSenha) {
        if(pe.matches(senhaAtual, usuarioComum.getSenha())) {
        	usuarioComum.setSenha(pe.encode(novaSenha));
            repository.save(usuarioComum);
            return true;
        } else {
            return false;
        }
    }
    
}
