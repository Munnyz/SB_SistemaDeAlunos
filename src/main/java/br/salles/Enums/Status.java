package br.salles.Enums;

public enum Status {
	ATIVO("Ativo"),
	INATIVO("Inativo"),
	TRANCADO("Trancado");
	
	private String status;
	
	private Status(String status) {
		this.status = status;
	}
}
