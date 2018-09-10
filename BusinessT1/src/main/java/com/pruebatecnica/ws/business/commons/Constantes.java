package com.pruebatecnica.ws.business.commons;

import java.util.logging.Logger;

import com.pruebatecnica.ws.business.dao.conection.Conection;

public class Constantes {

	public static class Utilidades {
		public static Logger logger = Logger.getLogger(Conection.class.getName());
		public static final String DB_URL = "jdbc:mysql://localhost:3306/kardex?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		public static final String DB_USER = "root";
		public static final String DB_PASSWORD = "";
		public static final String SI = "S";
		public static final String NO = "N";
		public static final int ENTRADA = 1;
		public static final int SALIDA = 2;
	}

}
