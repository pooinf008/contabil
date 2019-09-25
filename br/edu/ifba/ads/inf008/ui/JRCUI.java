package br.edu.ifba.ads.inf008.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JRCUI extends JFrame{
	
	
	private JTextField txtCredito;
	private JTextField txtDebito;
	private JTextField txtDescricao;
	private JTextField txtValor;
	
	private JButton btnInserir;
	
	public void run() {
		this.asm();
		this.setVisible(true);
	}

	private void asm() {
		
		this.txtCredito = new JTextField();
		this.txtDebito = new JTextField();
		this.txtDescricao = new JTextField();
		this.txtValor = new JTextField();
		this.btnInserir = new JButton("Inserir");
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(4, 2));
		panel.add(new JLabel("Conta Credito: "));
		panel.add(this.txtCredito);
		panel.add(new JLabel("Conta Debito: "));
		panel.add(this.txtDebito);	
		panel.add(new JLabel("Descrição:"));
		panel.add(this.txtDescricao);	
		panel.add(new JLabel("Valor R$:"));
		panel.add(this.txtValor);	
		
		this.setSize(400, 150);
		this.setTitle("Adiciona Fato");
		this.add(panel, BorderLayout.CENTER);
		this.add(btnInserir, BorderLayout.SOUTH);
		
		// TODO Auto-generated method stub
		
	}
	
	
	public static void main(String[] args) {
		(new JRCUI()).run();
	}

	
}
