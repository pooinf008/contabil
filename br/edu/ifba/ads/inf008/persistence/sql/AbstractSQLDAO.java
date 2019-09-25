package br.edu.ifba.ads.inf008.persistence.sql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractSQLDAO {
	
	private static final String JDBC_DRIVER = "org.hsqldb.jdbcDriver";
	private static final String URI = "jdbc:hsqldb:hsql://localhost/";
	private static final String USER = "SA";
	private static final String PWD = "";
	
	
	
	public Connection getConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		DriverManager.registerDriver((Driver)(Class.forName(AbstractSQLDAO.JDBC_DRIVER).newInstance()));
		return DriverManager.getConnection(AbstractSQLDAO.URI, AbstractSQLDAO.USER , AbstractSQLDAO.PWD);
	}

}
