package br.edu.ifba.ads.inf008.model.session;

import java.io.IOException;
import java.util.Collection;
import java.util.ListIterator;

import br.edu.ifba.ads.inf008.exceptions.ContaInexistenteException;
import br.edu.ifba.ads.inf008.exceptions.ContabilException;
import br.edu.ifba.ads.inf008.model.entidades.Ativo;
import br.edu.ifba.ads.inf008.model.entidades.Conta;
import br.edu.ifba.ads.inf008.model.entidades.Lancamento;
import br.edu.ifba.ads.inf008.model.entidades.Passivo;
import br.edu.ifba.ads.inf008.model.entidades.PatrimonioLiquido;
import br.edu.ifba.ads.inf008.persistence.ContaDAO;
import br.edu.ifba.ads.inf008.persistence.LancamentoDAO;
import br.edu.ifba.ads.inf008.persistence.file.ContaFileDAO;
import br.edu.ifba.ads.inf008.persistence.file.LancamentoFileDAO;
import br.edu.ifba.ads.inf008.persistence.memory.ContaMemoryDAO;
import br.edu.ifba.ads.inf008.persistence.memory.LancamentoMemoryDAO;

public class RegistroContabil{
	
  private ContaDAO contaDAO;
  private LancamentoDAO lancamentoDAO;	
  
  public RegistroContabil() throws ClassNotFoundException, IOException {
	  this.contaDAO = new ContaFileDAO();
	  this.lancamentoDAO = new LancamentoFileDAO();
  }
  
  public void registrarFato(String descricao, String nomeCredito,
                            String nomeDebito, double valor) throws ContaInexistenteException, ContabilException{
    Conta credito = this.contaDAO.findContaByNome(nomeCredito); 
    Conta debito = this.contaDAO.findContaByNome(nomeDebito); 
    Lancamento lancamento = new Lancamento(descricao, valor,
            credito, debito);   
    this.lancamentoDAO.save(lancamento);
    credito.creditar(valor);
    debito.debitar(valor);
    this.contaDAO.update(credito);
    this.contaDAO.update(debito);
  }    
  
  public void criarConta(String nome, int tipo) throws ContabilException{
	  Conta conta = null;
	  switch(tipo) {
	  	case 0 : conta = new Ativo(nome); break;
	  	case 1 : conta = new Passivo(nome); break;
	  	case 2 : conta = new PatrimonioLiquido(nome); break;	  	
	  }
	  this.contaDAO.save(conta);
  }
  
  public String LancamentostoStr() throws ContabilException {
	  String str = "LANCAMENTOS\n";
      for(Lancamento l : this.lancamentoDAO.findAll())
	    str += l + "\n";
	  return str;
  }
  
  public String BalancotoStr() throws ContabilException {
	  	String str = "BALANCO\n";
	  	for(Conta c : this.contaDAO.findAll())
	  		str += c + "\n";
	  	return str;
  }  
    
}
