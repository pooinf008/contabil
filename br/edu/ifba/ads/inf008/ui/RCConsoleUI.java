package br.edu.ifba.ads.inf008.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import br.edu.ifba.ads.inf008.exceptions.ContabilException;
import br.edu.ifba.ads.inf008.model.session.RegistroContabil;
import br.edu.ifba.ads.inf008.model.session.RegistroContabilApp;

public class RCConsoleUI {
	
	private RegistroContabilApp app;

	private BufferedReader br;

	public RCConsoleUI() throws ClassNotFoundException, IOException {
		this.app = new RegistroContabil();
		this.br = new BufferedReader(
	 			new InputStreamReader(System.in));	
	}
	
	private void adicionarRegistro() throws IOException, NumberFormatException, ContabilException {
		String credito;
		String debito;
		String descricao;
		double valor;
		
		System.out.println("ADICIONAR REGISTRO");
		System.out.println("1. Informe o nome da Conta Crédito:");
		credito = this.br.readLine();
		System.out.println("2. Informe o nome da Conta Débito:");
		debito = this.br.readLine();
		System.out.println("3. Informe a descrição do Fato Contábil:");
		descricao = this.br.readLine();
		System.out.println("4. Informe o valor do Fato Contábil:");
		valor = Double.parseDouble(this.br.readLine());
		this.app.registrarFato(credito, debito, descricao, valor);
		
	}
	
	public void run() {
		
		char option = '0';
		
		do {
			System.out.println("MENU");
			System.out.println("[1] - Adicionar Fato");
			System.out.println("[0] - SAIR");
			try {
				option = br.readLine().charAt(0);
			} catch (IOException e1) {
				System.out.println("ERRO LENDO OPÇÃO");
			}
			switch(option) {
				case '1' : try {
					this.adicionarRegistro();
				} catch (NumberFormatException ex) {
					System.err.println("O valor precisa ser um double");
				}catch(IOException | ContabilException e) {
					System.err.println("Fato não registrado causado por " + e);
				}
		        break;
			}
		}while(option != '0');
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		(new RCConsoleUI()).run();
	}
	

}
