package br.edu.ifba.ads.inf008.teste;

import br.edu.ifba.ads.inf008.example.exceptions.ContaInexistenteException;
import br.edu.ifba.ads.inf008.model.session.RegistroContabil;

public class App {
	
	private RegistroContabil rc; 
	
	public App() {
		this.rc = new RegistroContabil();
	}

	private void run() throws ContaInexistenteException {
		this.asmContas();
		this.asmRegistros();
		System.out.println(this.rc.LancamentostoStr());
		System.out.println("**************************");
		System.out.println(this.rc.BalancotoStr());
	}

	private void asmContas() {
		this.rc.criarConta("CAIXA", 0);
		this.rc.criarConta("IMOVEIS", 0);
		this.rc.criarConta("EMPRESTIMO", 1);
		this.rc.criarConta("CAPITAL INICIAL", 2);		
	}
	
	private void asmRegistros() throws ContaInexistenteException {
		this.rc.registrarFato("Integralização do capital subscrito", 
				              "CAPITAL INICIAL", 
				              "CAIXA", 10000);
		this.rc.registrarFato("Emprestimo no BNDES", 
	              "EMPRESTIMO", 
	              "CAIXA", 20000);
		this.rc.registrarFato("Compra da Sede", 
	              "CAIXA", 
	              "IMOVEIS", 15000);
	}
	
	
	public static void main(String[] args) throws ContaInexistenteException {
		(new  App()).run();
	}
	

}
