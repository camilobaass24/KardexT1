package com.pruebatecnica.ws.business.manager;

import java.util.List;

import com.pruebatecnica.ws.business.vo.Categoria;

public interface GestionarCategoriaManager {
	
	/**
	 * Metodo que devuelve todas las categorias
	 * @return
	 */
	List <Categoria> obtenerCategorias();
	
	/**
	 * metodo que registra una nueva categoria
	 * @param categoria
	 * @return
	 */
	boolean insertarCategoria(Categoria categoria);

}
