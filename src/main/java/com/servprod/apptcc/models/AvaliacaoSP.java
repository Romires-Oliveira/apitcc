package com.servprod.apptcc.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "avaliacao_sp")
public class AvaliacaoSP extends Generico{
	
    private String tipoUsurio;

    @OneToOne
    private UsuarioComum usuarioComum;

    @OneToOne
    private ServProd servProd;

    private String estrela;
    private String data;
    private String comentário;
    
	public String getTipoUsurio() {
		return tipoUsurio;
	}
	public void setTipoUsurio(String tipoUsurio) {
		this.tipoUsurio = tipoUsurio;
	}

	public UsuarioComum getUsuarioComum() {
		return usuarioComum;
	}
	public void setUsuarioComum(UsuarioComum usuarioComum) {
		this.usuarioComum = usuarioComum;
	}
	public ServProd getServProd() {
		return servProd;
	}
	public void setServProd(ServProd servProd) {
		this.servProd = servProd;
	}
	public String getEstrela() {
		return estrela;
	}
	public void setEstrela(String estrela) {
		this.estrela = estrela;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getComentário() {
		return comentário;
	}
	public void setComentário(String comentário) {
		this.comentário = comentário;
	}
    
}