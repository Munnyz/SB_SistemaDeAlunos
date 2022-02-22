package br.salles.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.salles.model.Aluno;

public interface AlunoDao extends JpaRepository<Aluno, Integer> {
	
	@Query("select j from Aluno j where j.status = 'ATIVO' ")
	public List<Aluno> findByStatusAtivos();
	
	@Query("select j from Aluno j where j.status = 'INATIVO' ")
	public List<Aluno> findByStatusInativos();
	
	@Query("select j from Aluno j where j.status = 'TRANCADO' ")
	public List<Aluno> findByStatusTrancados();
	
	public List<Aluno> findByNomeContainingIgnoreCase(String nome);
}
