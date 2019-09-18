package br.edu.ifba.ads.inf008.model.session;

import java.util.ListIterator;

import br.edu.ifba.ads.inf008.example.exceptions.ContaInexistenteException;
import br.edu.ifba.ads.inf008.model.entidades.Ativo;
import br.edu.ifba.ads.inf008.model.entidades.Conta;
import br.edu.ifba.ads.inf008.model.entidades.Lancamento;
import br.edu.ifba.ads.inf008.model.entidades.Passivo;
import br.edu.ifba.ads.inf008.model.entidades.PatrimonioLiquido;

public class RegistroContabil{
  private Balanco balanco = new Balanco();
  private LivroLancamentos livro = new LivroLancamentos();
  
  public void registrarFato(String descricao, String nomeCredito,
                            String nomeDebito, double valor) throws ContaInexistenteException{
    Conta credito = balanco.findContaByNome(nomeCredito); 
    Conta debito = balanco.findContaByNome(nomeDebito); 
    Lancamento lancamento = new Lancamento(descricao, valor,
            credito, debito);   
    this.livro.registrar(lancamento);
    this.balanco.ajustar(nomeCredito, nomeDebito, valor);
  }    
  
  public void criarConta(String nome, int tipo){
	  Conta conta = null;
	  switch(tipo) {
	  	case 0 : conta = new Ativo(nome); break;
	  	case 1 : conta = new Passivo(nome); break;
	  	case 2 : conta = new PatrimonioLiquido(nome); break;	  	
	  }
	  this.balanco.adicionarConta(conta);
  }
  
  public String LancamentostoStr() {
	  String str = "LANCAMENTOS\n";
	  ListIterator<Lancamento> lancamentos = this.livro.getLancamentos();
	  while(lancamentos.hasNext())
		  str += lancamentos.next();
	  return str;
  }
  
  public String BalancotoStr() {
	  return this.balanco.toString();
  }  
    
}
