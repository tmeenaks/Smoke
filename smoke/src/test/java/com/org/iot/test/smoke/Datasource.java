package com.org.iot.test.smoke;
import java.sql.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Datasource {


	final static Logger logger = Logger.getLogger(Datasource.class);
	private Connection  connection  = null;
	private Statement   statement   = null;
	private ResultSet   resultset   = null;

	String host;
	String port;
	String login;
	String password;
	String connurl;
	String db;

	public Datasource(String login, String password, String db, String host, String port, String url){
		logger.info("Database Connection Method Called");
		this.login=login;
		this.password=password;
		this.host=host;
		this.port=port;
		this.db=db;
		//this.url=url;
		connurl = url+host+":"+port+"/"+db;
		logger.info("Constructed Connection URL for the Database"+connurl);
		Connect();
	}

	private void Connect() {
		PropertyConfigurator.configure("log4j.properties");
		logger.info("JDBC Connection establisment initiated");
		// DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
		try {
			connection = DriverManager.getConnection(connurl, login, password);
			//statement = connection.createStatement();
			logger.info("Connection Established");
		}

		catch (SQLException e) {
			logger.error("Connection to the Database Failed\n"+e);
		}
	}


	public ResultSet Query(String query){

		try {
			statement = connection.createStatement();
			resultset = statement.executeQuery(query);
		}
		catch (Exception e) {
			logger.error("Exception occured:\n" + e.getMessage());
		}
		return resultset;
	}


	public void Change(String query){

		try {
			statement = connection.createStatement();
			int rec1 = statement.executeUpdate(query);
							
				logger.info("Records used by the Automation Setup inthe previous run is removed\t"+rec1);			

		}
		catch (Exception e) {
			logger.error("Exception occured:\n" + e.getMessage());
		}

	}


	public void closeConnection(){

		try {
			connection.close();
			connection = null;
		}
		catch(Exception e)         {
			logger.error("Closing Execption\n"+e);
		}

	}

}


