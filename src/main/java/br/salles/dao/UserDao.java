package br.salles.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.salles.model.usuario;

public interface UserDao extends JpaRepository<usuario, Integer> {

	@Query("select i from usuario i where i.username = :username and i.senha = :senha")
	public usuario Logar(String username, String senha);
}
