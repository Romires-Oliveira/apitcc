package com.servprod.apptcc.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "pessoafisica")
public class PessoaFisica extends Generico{

    private String nomeComplete;
    private String nomeUsuario;
    private String CPF;

    public String getNomeComplete() {
        return nomeComplete;
    }

    public void setNomeComplete(String nomeComplete) {
        this.nomeComplete = nomeComplete;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }	
}
