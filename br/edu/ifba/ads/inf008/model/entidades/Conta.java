package br.edu.ifba.ads.inf008.model.entidades;

import java.io.Serializable;

public abstract class Conta implements Serializable{
    private String nome;
    protected double saldo;
    
    public Conta() {
	}	
    
    public Conta(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome(){
        return this.nome;
    }   
	
	
    
    public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getSaldo() {
		return saldo;
	}

	public abstract void creditar(double valor);   
    
    public abstract void debitar(double valor);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}  
	
	public String toString() {
		return this.nome + ": R$" + this.saldo;
	}
 
    
    
}
