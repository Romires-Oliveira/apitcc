package com.servprod.apptcc.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@Table(name ="servicos_produtos")	
public class ServProd extends Generico {
	
	@OneToOne
	private CategoriaSP cateriasp;
	
	private String nomeServProd;
	
	private String descricao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	private String celular;
	private String TelFixo;
	private String diaFuncionamento;
	private String horarioFuncionamento;
	
	private String horarioInicio;
    private String horarioFinal;
    private String diaInicio;
    private String diaFinal;
    
    @ManyToOne
    private Prestador prestador;
    
	public CategoriaSP getCateriasp() {
		return cateriasp;
	}
	public void setCateriasp(CategoriaSP cateriasp) {
		this.cateriasp = cateriasp;
	}
	public String getNomeServProd() {
		return nomeServProd;
	}
	public void setNomeServProd(String nomeServProd) {
		this.nomeServProd = nomeServProd;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getTelFixo() {
		return TelFixo;
	}
	public void setTelFixo(String telFixo) {
		TelFixo = telFixo;
	}
	
	public String getDiaFuncionamento() {
		return diaFuncionamento;
	}
	public void setDiaFuncionamento(String diaFuncionamento) {
		this.diaFuncionamento = diaFuncionamento;
	}
	public String getHorarioFuncionamento() {
		return horarioFuncionamento;
	}
	public void setHorarioFuncionamento(String horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}
	
	public Prestador getPrestador() {
		return prestador;
	}
	public void setPrestador(Prestador prestador) {
		this.prestador = prestador;
	}
	
	
	public String getHorarioInicio() {
		return horarioInicio;
	}
	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	public String getHorarioFinal() {
		return horarioFinal;
	}
	public void setHorarioFinal(String horarioFinal) {
		this.horarioFinal = horarioFinal;
	}
	public String getDiaInicio() {
		return diaInicio;
	}
	public void setDiaInicio(String diaInicio) {
		this.diaInicio = diaInicio;
	}
	public String getDiaFinal() {
		return diaFinal;
	}
	public void setDiaFinal(String diaFinal) {
		this.diaFinal = diaFinal;
	}
	
}
