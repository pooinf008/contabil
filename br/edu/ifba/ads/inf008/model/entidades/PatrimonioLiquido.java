package br.edu.ifba.ads.inf008.model.entidades;
public class PatrimonioLiquido extends Conta{
	
   public PatrimonioLiquido() {

	}
	
    public PatrimonioLiquido(String nome) {
		super(nome);
	}
	
    public void creditar(double valor){
      this.saldo += valor;
    }    
    
    public void debitar(double valor){
      this.saldo -= valor;
    }        
}