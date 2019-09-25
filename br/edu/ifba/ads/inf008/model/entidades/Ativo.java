package br.edu.ifba.ads.inf008.model.entidades;
public class Ativo extends Conta{
	
    public Ativo() {
	}	
	
    public Ativo(String nome) {
		super(nome);
	}
    

	public void creditar(double valor){
      this.saldo -= valor;
    }    
    
    public void debitar(double valor){
      this.saldo += valor;
    }        
}
