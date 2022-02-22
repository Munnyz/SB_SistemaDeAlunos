package br.salles.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.salles.Enums.Curso;
import br.salles.Enums.Status;

@Entity
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	@Column(name = "nome")
	@Size(min = 5, max = 35, message = "O nome deve conter no minimo 5 caracteres!")
	@NotNull(message = "O nome não pode ser vazio")
	private String nome;
	
	@Column(name = "curso")
	@Enumerated(EnumType.STRING)
	private Curso curso;
	
	@Column(name = "matricula")
	@NotNull(message = "Clique no botão Gerar!")
	@Size(min = 3, message = "Clique no botão Gerar matricula!")
	private String matricula;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
