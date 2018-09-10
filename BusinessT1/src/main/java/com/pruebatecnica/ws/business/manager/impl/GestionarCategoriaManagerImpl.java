package com.pruebatecnica.ws.business.manager.impl;

import java.util.List;
import java.util.logging.Level;

import com.pruebatecnica.ws.business.commons.Constantes.Utilidades;
import com.pruebatecnica.ws.business.dao.AdministrarCategoriasDao;
import com.pruebatecnica.ws.business.dao.impl.AdministrarCategoriasDaoJdbc;
import com.pruebatecnica.ws.business.manager.GestionarCategoriaManager;
import com.pruebatecnica.ws.business.vo.Categoria;

public class GestionarCategoriaManagerImpl implements GestionarCategoriaManager {

	private AdministrarCategoriasDao administrarCategoriasDao;

	public GestionarCategoriaManagerImpl() {
		administrarCategoriasDao = new AdministrarCategoriasDaoJdbc();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pruebatecnica.ws.business.manager.GestionarCategoriaManager#
	 * obtenerCategorias()
	 */
	public List<Categoria> obtenerCategorias() {

		try {
			return administrarCategoriasDao.obtenerCategorias();
		} catch (Exception e) {
			Utilidades.logger.log(Level.INFO, e.toString());
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pruebatecnica.ws.business.manager.GestionarCategoriaManager#
	 * insertarCategoria(com.pruebatecnica.ws.business.vo.Categoria)
	 */
	public boolean insertarCategoria(Categoria categoria) {
		try {
			administrarCategoriasDao.insertarCategoria(categoria.getNombre(), categoria.getActivo());
			return true;
		} catch (Exception e) {
			return false;
		}

	}
}