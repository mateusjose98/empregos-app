package com.mateus.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Vaga")
public class Vaga {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	private Date data;
	private Double salario;
	private Integer destacado;
	private String imagem = "no-image.png";
	private String status;
	private String detalhes;
	
	//uma Vaga tem uma Categoria
	
	
//	@Transient --> // ignora o atributo no bootstrap da aplicação
	
	@OneToOne
	@JoinColumn(name = "Categoria_id")
	private Categoria categoria;
	



	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


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
	
	public void reset() {
		this.imagem = null;
	}


	@Override
	public String toString() {
		return "Vaga, categoria:"+ categoria +  "[id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", data=" + data + ", salario="
				+ salario + ", destacado=" + destacado + ", imagem=" + imagem + ", status=" + status + ", detalhes="
				+ detalhes + "]";
	}


	
	
	

}
