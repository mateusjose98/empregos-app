package com.mateus.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Solicitacao {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "data")
	private Date data_aplicacao;
	private String arquivo;
	
	private String comentarios;
	
	@ManyToOne
	@JoinColumn(name = "Usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "Vaga_id")
	private Vaga vaga;
	

	public Solicitacao() {
		
	}

	public Solicitacao(Integer id, Date data_aplicacao, String arquivo, String comentarios, Usuario usuario,
			Vaga vaga) {
		super();
		this.id = id;
		this.data_aplicacao = data_aplicacao;
		this.arquivo = arquivo;
		this.comentarios = comentarios;
		this.usuario = usuario;
		this.vaga = vaga;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData_aplicacao() {
		return data_aplicacao;
	}

	public void setData_aplicacao(Date data_aplicacao) {
		this.data_aplicacao = data_aplicacao;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solicitacao other = (Solicitacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Solicitacao [id=" + id + ", data_aplicacao=" + data_aplicacao + ", arquivo=" + arquivo
				+ ", comentarios=" + comentarios + ", usuario=" + usuario + ", vaga=" + vaga + "]";
	}
	

	
	
	
}
