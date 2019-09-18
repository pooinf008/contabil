package br.edu.ifba.ads.inf008.persistence;

import java.util.Collection;

import br.edu.ifba.ads.inf008.exceptions.ContabilException;
import br.edu.ifba.ads.inf008.model.entidades.Lancamento;

public interface LancamentoDAO {
	
	public void save(Lancamento lancamento) throws ContabilException;
	public Collection<Lancamento> findAll() throws ContabilException;

}
