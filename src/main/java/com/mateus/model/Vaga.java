package com.mateus.model;

import java.util.Date;

public class Vaga {
	
	private Integer id;
	private String nome;
	private String descricao;
	private Date data;
	private Double salario;
	private Integer destacado;
	private String imagem = "no-image.png";
	private String status;
	private String detalhes;
	



	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDetalhes() {
		return detalhes;
	}


	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}


	public String getImagem() {
		return imagem;
	}


	public void setImagem(String imagem) {
		this.imagem = imagem;
	}


	public Vaga() {

	}
	
	
	public Vaga(Integer id, String nome, String descricao, Date data, Double salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.data = data;
		this.salario = salario;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
	public Integer getDestacado() {
		return destacado;
	}


	public void setDestacado(Integer destacado) {
		this.destacado = destacado;
	}


	@Override
	public String toString() {
		return "Vaga [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", data=" + data + ", salario="
				+ salario + ", destacado=" + destacado + ", imagem=" + imagem + ", status=" + status + ", detalhes="
				+ detalhes + "]";
	}


	
	
	

}
