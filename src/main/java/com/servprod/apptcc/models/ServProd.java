package com.servprod.apptcc.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@Table(name ="servicos_produtos")	
public class ServProd extends Generico {
	
	@OneToOne
	private CategoriaSP cateriasp;
	
	private String descricao;
	
	@OneToMany
	private List<Endereco> endereco;
	
	private String celular;
	private String TelFixo;
	private String horarioInicio;
    private String horarioFinal;
    private String diaInicio;
    private String diaFinal;
    
	public CategoriaSP getCateriasp() {
		return cateriasp;
	}
	public void setCateriasp(CategoriaSP cateriasp) {
		this.cateriasp = cateriasp;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Endereco> getEndereco() {
		return endereco;
	}
	public void setEndereco(List<Endereco> endereco) {
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
