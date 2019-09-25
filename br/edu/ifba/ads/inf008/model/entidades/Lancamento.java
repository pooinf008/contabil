package br.edu.ifba.ads.inf008.model.entidades;

import java.io.Serializable;

public class Lancamento implements Serializable{
    private String descricao;
    private double valor;
    private Conta credito;
    private Conta debito;
    
    public Lancamento() {
    	
    }
    
    public Lancamento(String descricao, double valor,
                      Conta credito, Conta debito){
      this.descricao = descricao;
      this.valor = valor;
      this.credito = credito;
      this.debito = debito;
    }
    
    
    
    public String getDescricao() {
		return descricao;
	}



	public double getValor() {
		return valor;
	}



	public Conta getCredito() {
		return credito;
	}



	public Conta getDebito() {
		return debito;
	}


	
	

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public void setValor(double valor) {
		this.valor = valor;
	}



	public void setCredito(Conta credito) {
		this.credito = credito;
	}



	public void setDebito(Conta debito) {
		this.debito = debito;
	}



	public String toString() {
    	return "Descricao: " + this.descricao + "\n" +
    		   "Valor: R$ " + this.valor + "\n" +
    		   "(C) " + this.credito.getNome()  + "\n" + 
    	       "(D) " + this.debito.getNome()  + "\n";
    }
    
}
