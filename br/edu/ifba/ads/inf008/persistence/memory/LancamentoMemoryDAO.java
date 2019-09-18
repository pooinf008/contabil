package br.edu.ifba.ads.inf008.persistence.memory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.edu.ifba.ads.inf008.exceptions.ContabilException;
import br.edu.ifba.ads.inf008.model.entidades.Lancamento;
import br.edu.ifba.ads.inf008.persistence.LancamentoDAO;

public class LancamentoMemoryDAO implements LancamentoDAO{

	
	protected List<Lancamento> lancamentos;

    public LancamentoMemoryDAO() throws ClassNotFoundException, IOException {
    	this.init();
	}
    
    protected void init() throws IOException, ClassNotFoundException{
    	this.lancamentos = new ArrayList<Lancamento>();
    }
    
	
	@Override
	public void save(Lancamento lancamento) throws ContabilException {
		this.lancamentos.add(lancamento);
	}

	@Override
	public Collection<Lancamento> findAll() throws ContabilException {
		return this.lancamentos;
	}

}
