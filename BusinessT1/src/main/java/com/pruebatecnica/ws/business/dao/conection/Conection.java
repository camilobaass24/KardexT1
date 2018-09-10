package com.pruebatecnica.ws.business.dao.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;

import com.pruebatecnica.ws.business.commons.Constantes.Utilidades;

public class Conection {

	
	
	 private Conection() {
		    throw new IllegalStateException("Utility class");
		  }

	/**
	 * Se gestiona la conexion a base de datos
	 * @return
	 */
	public static Connection conection() throws Exception {
		Connection con;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(Utilidades.DB_URL, Utilidades.DB_USER, Utilidades.DB_PASSWORD);
			return con;

		} catch (Exception e) {
			Utilidades.logger.log(Level.INFO, e.toString());
			throw new Exception();

		}

	}

	/**
	 * Se gestionan las sentencias sql
	 * @return
	 */
	public static Statement st() {
		Statement stmt;
		try {
			stmt = Conection.conection().createStatement();
			return stmt;
		} catch (Exception e) {
			Utilidades.logger.log(Level.INFO, e.toString());
			return null;
		}

	}

}
