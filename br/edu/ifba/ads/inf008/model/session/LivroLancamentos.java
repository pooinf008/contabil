package br.edu.ifba.ads.inf008.model.session;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import br.edu.ifba.ads.inf008.model.entidades.Lancamento;

public class LivroLancamentos{
    private List<Lancamento> lancamentos;
    
    public LivroLancamentos(){
        this.lancamentos = new ArrayList<Lancamento>();
    }    
    
    public void registrar(Lancamento lancamento){
    	this.lancamentos.add(lancamento);
    }   
    
    public ListIterator<Lancamento> getLancamentos(){
    	return this.lancamentos.listIterator();
    }
    
}
