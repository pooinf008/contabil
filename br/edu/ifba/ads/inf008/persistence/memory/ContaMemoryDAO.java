package br.edu.ifba.ads.inf008.persistence.memory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.ifba.ads.inf008.exceptions.ContaInexistenteException;
import br.edu.ifba.ads.inf008.exceptions.ContabilException;
import br.edu.ifba.ads.inf008.model.entidades.Conta;
import br.edu.ifba.ads.inf008.persistence.ContaDAO;

public class ContaMemoryDAO implements ContaDAO{

	
    protected Map<String, Conta> contas;

    public ContaMemoryDAO() throws ClassNotFoundException, IOException {
    	this.init();
    }    
    
    protected void init() throws IOException, ClassNotFoundException {
   		this.contas = new HashMap<String, Conta>();
    }
	
	@Override
	public void save(Conta c) throws ContabilException {
    	this.contas.put(c.getNome(), c);
	}

	@Override
	public Conta findContaByNome(String nome) throws ContaInexistenteException, ContabilException {
    	Conta conta = this.contas.get(nome);
    	if(conta == null)
    		throw new ContaInexistenteException(nome);
    	return conta;
	}

	@Override
	public void update(Conta c) throws ContabilException {
		this.save(c);
	}

	@Override
	public Collection<Conta> findAll() throws ContabilException {
		return this.contas.values();
	}

}
