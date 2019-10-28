package com.servprod.apptcc.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "prestador")
public class Prestador extends Generico{

    @OneToOne
    private PessoaFisica tipoPessoaFisica;
    @OneToOne
    private PessoaJuridica tipoPessoaJuridica;

	public PessoaFisica getTipoPessoaFisica() {
		return tipoPessoaFisica;
	}

	public void setTipoPessoaFisica(PessoaFisica tipoPessoaFisica) {
		this.tipoPessoaFisica = tipoPessoaFisica;
	}

	public PessoaJuridica getTipoPessoaJuridica() {
		return tipoPessoaJuridica;
	}

	public void setTipoPessoaJuridica(PessoaJuridica tipoPessoaJuridica) {
		this.tipoPessoaJuridica = tipoPessoaJuridica;
	}	
}
