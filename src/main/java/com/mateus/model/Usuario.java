package com.mateus.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private String email;
	
	private String username;
	
	private String password;
	
	private Date dataRegistro = new Date();
	
	private Integer Status = 1;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="UsuarioPerfil",
			joinColumns = @JoinColumn(name = "Usuario_id"),
			inverseJoinColumns = @JoinColumn(name = "Perfil_id")
				)
	private List<Perfil> perfis;

	public Usuario(Integer id, String nome, String email, String username, String password, Date dataRegistro) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.username = username;
		this.password = password;
		this.dataRegistro = dataRegistro;
	}
	
	public void agregarPerfilaUsuario(Perfil perfil) {
		if(perfis == null) {
			perfis = new LinkedList<Perfil>();
		}
		
		perfis.add(perfil);
	}
	
	public Usuario() {

	}
	
	

	public Integer getStatus() {
		return Status;
	}

	public void setStatus(Integer status) {
		Status = status;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}
	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Date getDataRegistro() {
		return dataRegistro;
	}



	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}



	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", username=" + username + ", password="
				+ password + ", dataRegistro=" + dataRegistro + "]";
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
