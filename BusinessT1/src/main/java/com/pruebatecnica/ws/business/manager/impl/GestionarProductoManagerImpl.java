package com.pruebatecnica.ws.business.manager.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.pruebatecnica.ws.business.commons.Constantes.Utilidades;
import com.pruebatecnica.ws.business.dao.GestionarProductoDao;
import com.pruebatecnica.ws.business.dao.impl.GestionarProductoDaoJdbc;
import com.pruebatecnica.ws.business.manager.GestionarProductoManager;
import com.pruebatecnica.ws.business.vo.Producto;

public class GestionarProductoManagerImpl implements GestionarProductoManager {

	private GestionarProductoDao gestionarProductoDao;

	/*
	 * Constructor de la clase
	 */
	public GestionarProductoManagerImpl() throws Exception {
		gestionarProductoDao = new GestionarProductoDaoJdbc();
	}

	/*
	 * (non-Javadoc)
	 * @see com.pruebatecnica.ws.business.manager.GestionarProductoManager#registrarProducto(com.pruebatecnica.ws.business.vo.Producto)
	 */
	public boolean registrarProducto(Producto producto) {

		try {
			gestionarProductoDao.registrarProducto(producto);
			return true;
		} catch (Exception e) {
			Utilidades.logger.log(Level.INFO, e.toString());
			return false;
		}

	}

	/*
	 * (non-Javadoc)
	 * @see com.pruebatecnica.ws.business.manager.GestionarProductoManager#obtenerProductos()
	 */
	public List<Producto> obtenerProductos() {
		List <Producto>productos= new ArrayList<Producto>();
		try
		{
			productos= gestionarProductoDao.obtenerProductos();
			return productos;
		}catch (Exception e) {
			return productos;
		}
	}

}
