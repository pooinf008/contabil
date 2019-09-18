package br.edu.ifba.ads.inf008.persistence.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import br.edu.ifba.ads.inf008.exceptions.ContabilException;
import br.edu.ifba.ads.inf008.model.entidades.Conta;
import br.edu.ifba.ads.inf008.persistence.memory.ContaMemoryDAO;

public class ContaFileDAO extends ContaMemoryDAO{
	
	private static final String fileName = "C:\\Users\\Aluno\\eclipse-workspace\\FatoContabil\\CONTA.data";
	
	
    public ContaFileDAO() throws ClassNotFoundException, IOException {
		super();
	}

	protected void init() throws IOException, ClassNotFoundException {
    	File file = new File(ContaFileDAO.fileName);
    	if(file.canRead()) {
    		FileInputStream inputStream = new FileInputStream(file);
    		ObjectInputStream ois = new ObjectInputStream(inputStream);
    		this.contas = (Map<String, Conta>) ois.readObject();
    		ois.close();
    		inputStream.close();
    	}else {
    		this.contas = new HashMap<String, Conta>();
    	}	
    }
	
    public void persist() throws IOException {
		FileOutputStream outputStream = new FileOutputStream(new File(ContaFileDAO.fileName));
		ObjectOutputStream oos = new ObjectOutputStream(outputStream);
		oos.writeObject(this.contas);
		oos.close();
		outputStream.close();
    }
	
	
	@Override
	public void save(Conta c) throws ContabilException {
		super.save(c);
    	try {
			this.persist();
		} catch (IOException e) {
			throw new ContabilException(e);
		}
	}
	
	

}
