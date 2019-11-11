package com.servprod.apptcc.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "categoria_sp")
public class CategoriaSP extends Generico{

    private String nomeCategoria;
    private String statusCategoria;
    
    @ManyToOne
    private UsuarioComum usuarioComum;

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

	public String getStatusCategoria() {
		return statusCategoria;
	}

	public void setStatusCategoria(String statusCategoria) {
		this.statusCategoria = statusCategoria;
	}

	public UsuarioComum getUsuarioComum() {
		return usuarioComum;
	}

	public void setUsuarioComum(UsuarioComum usuarioComum) {
		this.usuarioComum = usuarioComum;
	}
}
