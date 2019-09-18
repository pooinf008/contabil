package br.edu.ifba.ads.inf008.persistence;

import java.util.Collection;

import br.edu.ifba.ads.inf008.exceptions.ContaInexistenteException;
import br.edu.ifba.ads.inf008.exceptions.ContabilException;
import br.edu.ifba.ads.inf008.model.entidades.Conta;

public interface ContaDAO {
	public void save(Conta c) throws ContabilException;
	public Conta findContaByNome(String nome) throws ContaInexistenteException, ContabilException;
	public void update(Conta c) throws ContabilException;
	public Collection<Conta> findAll() throws ContabilException;
}
