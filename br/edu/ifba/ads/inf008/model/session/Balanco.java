package br.edu.ifba.ads.inf008.model.session;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifba.ads.inf008.example.exceptions.ContaInexistenteException;
import br.edu.ifba.ads.inf008.model.entidades.Conta;

public class Balanco{
    private Map<String, Conta> contas;
    
    public Balanco() {
    	this.contas = new HashMap<String, Conta>();
    }
    
    public void adicionarConta(Conta conta) {
    	this.contas.put(conta.getNome(), conta);
    }
    
    public Conta findContaByNome(String nome) throws ContaInexistenteException{
    	Conta conta = this.contas.get(nome);
    	if(conta == null)
    		throw new ContaInexistenteException(nome);
    	return conta;
    }  
    
    public void ajustar(String nomeCredito, String nomeDebito, 
                        double valor) throws ContaInexistenteException{
      Conta credito = this.findContaByNome(nomeCredito);
      Conta debito = this.findContaByNome(nomeDebito);
      credito.creditar(valor);
      debito.debitar(valor);      
    }    
    
    public String toString() {
    	String str = "BALANCO\n";
    	for(Conta c : this.contas.values())
    		str += c + "\n";
    	return str;
    }
    
}
