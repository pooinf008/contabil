package br.edu.ifba.ads.inf008.persistence.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.edu.ifba.ads.inf008.exceptions.ContaInexistenteException;
import br.edu.ifba.ads.inf008.exceptions.ContabilException;
import br.edu.ifba.ads.inf008.model.entidades.Conta;
import br.edu.ifba.ads.inf008.model.entidades.Lancamento;
import br.edu.ifba.ads.inf008.persistence.LancamentoDAO;

public class LancamentoSQLDAO extends AbstractSQLDAO implements LancamentoDAO {

	private static final String INSERT_LANCAMENTO = 
			"INSERT INTO LANCAMENTO(descricao, valor, nomeCredito, nomeDebito) " +
			"VALUES(?, ?, ?, ?)";
	
	private static final String SELECT_LANCAMENTO = 
			"SELECT descricao, valor, nomeCredito, nomeDebito FROM LANCAMENTO";
	
	
	@Override
	public void save(Lancamento lancamento) throws ContabilException {
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(LancamentoSQLDAO.INSERT_LANCAMENTO);
			stmt.setString(1, lancamento.getDescricao());
			stmt.setDouble(2, lancamento.getValor());
			stmt.setString(3, lancamento.getCredito().getNome());
			stmt.setString(4, lancamento.getDebito().getNome());			
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
	public Collection<Lancamento> findAll() throws ContabilException {
		ContaSQLDAO contaDAO = new ContaSQLDAO();
		List<Lancamento> lancamentos = new ArrayList<Lancamento>();
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(LancamentoSQLDAO.SELECT_LANCAMENTO);
			ResultSet rSet = stmt.executeQuery();
			while(rSet.next()) {
				Lancamento l = new Lancamento();
				l.setDescricao(rSet.getString("descricao"));
				l.setValor(rSet.getDouble("valor"));
				l.setCredito(contaDAO.findContaByNome(rSet.getString("nomeCredito")));
				l.setDebito(contaDAO.findContaByNome(rSet.getString("nomeDebito")));
				lancamentos.add(l);
			}
		} catch (SQLException e) {
			throw new ContabilException(e);
		} catch (InstantiationException e) {
			throw new ContabilException(e);
		} catch (IllegalAccessException e) {
			throw new ContabilException(e);
		} catch (ClassNotFoundException e) {
			throw new ContabilException(e);		
		}catch (ContaInexistenteException e) {
			throw new ContabilException(e);		
		}
		return lancamentos;
	}

}
