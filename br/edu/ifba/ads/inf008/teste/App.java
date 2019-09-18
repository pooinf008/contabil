package br.edu.ifba.ads.inf008.teste;

import java.io.IOException;

import br.edu.ifba.ads.inf008.exceptions.ContaInexistenteException;
import br.edu.ifba.ads.inf008.exceptions.ContabilException;
import br.edu.ifba.ads.inf008.model.session.RegistroContabil;

public class App {
	
	private RegistroContabil rc; 
	
	public App() throws ClassNotFoundException, IOException {
		this.rc = new RegistroContabil();
	}

	private void run() throws ContaInexistenteException, ContabilException {
//		this.asmContas();
		this.asmRegistros();
		System.out.println(this.rc.LancamentostoStr());
		System.out.println("**************************");
		System.out.println(this.rc.BalancotoStr());
	}

	private void asmContas() throws ContabilException {
		this.rc.criarConta("CAIXA", 0);
		this.rc.criarConta("IMOVEIS", 0);
		this.rc.criarConta("EMPRESTIMO", 1);
		this.rc.criarConta("CAPITAL INICIAL", 2);		
	}
	
	private void asmRegistros() throws ContaInexistenteException, ContabilException {
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
	
	
	public static void main(String[] args) throws ContaInexistenteException, ContabilException, ClassNotFoundException, IOException {
		(new  App()).run();
	}
	

}
