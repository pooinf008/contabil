package br.edu.ifba.ads.inf008.model.entidades;

import javax.print.StreamPrintServiceFactory;

public class Lancamento{
    private String descricao;
    private double valor;
    private Conta credito;
    private Conta debito;
    
    public Lancamento(String descricao, double valor,
                      Conta credito, Conta debito){
      this.descricao = descricao;
      this.valor = valor;
      this.credito = credito;
      this.debito = debito;
    }
    
    public String toString() {
    	return "Descricao: " + this.descricao + "\n" +
    		   "Valor: R$ " + this.valor + "\n" +
    		   "(C) " + this.credito.getNome()  + "\n" + 
    	       "(D) " + this.debito.getNome()  + "\n";
    }
    
}
