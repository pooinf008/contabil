package br.edu.ifba.ads.inf008.persistence.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.ads.inf008.exceptions.ContabilException;
import br.edu.ifba.ads.inf008.model.entidades.Conta;
import br.edu.ifba.ads.inf008.model.entidades.Lancamento;
import br.edu.ifba.ads.inf008.persistence.LancamentoDAO;
import br.edu.ifba.ads.inf008.persistence.memory.LancamentoMemoryDAO;

public class LancamentoFileDAO extends LancamentoMemoryDAO implements LancamentoDAO {
	private static final String fileName = "C:\\Users\\Aluno\\eclipse-workspace\\FatoContabil\\LANCAMENTO.data";
	
	
	
	public LancamentoFileDAO() throws ClassNotFoundException, IOException {
		super();
	}



	protected void init() throws IOException, ClassNotFoundException {
    	File file = new File(LancamentoFileDAO.fileName);
    	if(file.canRead()) {
    		FileInputStream inputStream = new FileInputStream(file);
    		ObjectInputStream ois = new ObjectInputStream(inputStream);
    		this.lancamentos = (List<Lancamento>) ois.readObject();
    		ois.close();
    		inputStream.close();
    	}else {
    		this.lancamentos = new ArrayList<Lancamento>();
    	}	
    }	
	
    public void persist() throws IOException {
		FileOutputStream outputStream = new FileOutputStream(new File(LancamentoFileDAO.fileName));
		ObjectOutputStream oos = new ObjectOutputStream(outputStream);
		oos.writeObject(this.lancamentos);
		oos.close();
		outputStream.close();
    }	
    
	@Override
	public void save(Lancamento lancamento) throws ContabilException {
		super.save(lancamento);
		try {
			this.persist();
		} catch (IOException e) {
			throw new ContabilException(e);
		}
	}    
}
