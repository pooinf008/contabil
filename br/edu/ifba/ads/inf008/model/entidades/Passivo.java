package br.edu.ifba.ads.inf008.model.entidades;
public class Passivo extends Conta{
  
    
    public Passivo() {
	}		
	
    public Passivo(String nome) {
		super(nome);
	}
	
	
    public void creditar(double valor){
      this.saldo += valor;
    }    
    
    public void debitar(double valor){
      this.saldo -= valor;
    }        
}