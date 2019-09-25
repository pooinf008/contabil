package br.edu.ifba.ads.inf008.persistence.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.edu.ifba.ads.inf008.exceptions.ContaInexistenteException;
import br.edu.ifba.ads.inf008.exceptions.ContabilException;
import br.edu.ifba.ads.inf008.model.entidades.Ativo;
import br.edu.ifba.ads.inf008.model.entidades.Conta;
import br.edu.ifba.ads.inf008.model.entidades.Passivo;
import br.edu.ifba.ads.inf008.model.entidades.PatrimonioLiquido;
import br.edu.ifba.ads.inf008.persistence.ContaDAO;

public class ContaSQLDAO extends AbstractSQLDAO implements ContaDAO{

	private static final String INSERT_CONTA = 
			"INSERT INTO CONTA(nome, saldo, tipo) " +
			"VALUES(?, ?, ?)";

	private static final String SELECT_CONTA_NOME = 
			"SELECT nome, saldo, tipo FROM CONTA " +
			"WHERE nome = ?";
	
	private static final String UPDATE_CONTA = 
			"UPDATE CONTA " + 
			"SET saldo = ? " +
			"WHERE nome = ?";
	
	private static final String SELECT_CONTA = 
			"SELECT nome, saldo, tipo FROM CONTA";
	
	
	@Override
	public void save(Conta c) throws ContabilException {
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(ContaSQLDAO.INSERT_CONTA);
			stmt.setString(1, c.getNome());
			stmt.setDouble(2, c.getSaldo());
			stmt.setInt(3,this.typeToInt(c));
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new ContabilException(e);
		} catch (InstantiationException e) {
			throw new ContabilException(e);
		} catch (IllegalAccessException e) {
			throw new ContabilException(e);
		} catch (ClassNotFoundException e) {
			throw new ContabilException(e);		
		}
	}

	@Override
	public Conta findContaByNome(String nome) throws ContaInexistenteException, ContabilException {
		Conta c = null;
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(ContaSQLDAO.SELECT_CONTA_NOME);
			stmt.setString(1, nome);
			ResultSet rSet = stmt.executeQuery();
			if(rSet.next()) {
				c = this.intToType(rSet.getInt("tipo"));
				c.setNome(rSet.getString("nome"));
				c.setSaldo(rSet.getDouble("saldo"));
			}
		} catch (SQLException e) {
			throw new ContabilException(e);
		} catch (InstantiationException e) {
			throw new ContabilException(e);
		} catch (IllegalAccessException e) {
			throw new ContabilException(e);
		} catch (ClassNotFoundException e) {
			throw new ContabilException(e);		
		}
		return c;
	}

	@Override
	public void update(Conta c) throws ContabilException {
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(ContaSQLDAO.UPDATE_CONTA);
			stmt.setDouble(1, c.getSaldo());
			stmt.setString(2, c.getNome());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new ContabilException(e);
		} catch (InstantiationException e) {
			throw new ContabilException(e);
		} catch (IllegalAccessException e) {
			throw new ContabilException(e);
		} catch (ClassNotFoundException e) {
			throw new ContabilException(e);		
		}
	}

	@Override
	public Collection<Conta> findAll() throws ContabilException {
		List<Conta> contas = new ArrayList<Conta>();
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(ContaSQLDAO.SELECT_CONTA);
			ResultSet rSet = stmt.executeQuery();
			while(rSet.next()) {
				Conta c;
				c = this.intToType(rSet.getInt("tipo"));
				c.setNome(rSet.getString("nome"));
				c.setSaldo(rSet.getDouble("saldo"));
				contas.add(c);
			}
		} catch (SQLException e) {
			throw new ContabilException(e);
		} catch (InstantiationException e) {
			throw new ContabilException(e);
		} catch (IllegalAccessException e) {
			throw new ContabilException(e);
		} catch (ClassNotFoundException e) {
			throw new ContabilException(e);		
		}
		return contas;
	}
	
	private int typeToInt(Conta c) {
		if(c.getClass() == Ativo.class)
			return 1;
		else if(c.getClass() == Passivo.class)
			return 2;
		else if(c.getClass() == PatrimonioLiquido.class)
			return 3;
		return 0;
	}
	
	private Conta intToType(int i) {
		if(i == 1)
			return new Ativo();
		if(i == 2)
			return new Passivo();
		if(i == 3)
			return new PatrimonioLiquido();
		return null;
	}	

}
