package br.edu.ifba.ads.inf008.exceptions;

public class ContaInexistenteException extends 
	Exception{

	private static final long serialVersionUID = 1L;
	private String nome;
	
	public ContaInexistenteException(String nome) {
		super();
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
}
	
