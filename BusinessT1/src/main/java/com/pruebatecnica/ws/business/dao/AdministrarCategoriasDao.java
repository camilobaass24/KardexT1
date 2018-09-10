package com.pruebatecnica.ws.business.dao;

import java.util.List;

import com.pruebatecnica.ws.business.vo.Categoria;

public interface AdministrarCategoriasDao {

	/**
	 * Metodo que actualiza una categoria
	 * 
	 * @param idCategoria
	 * @return
	 * @throws Exception 
	 */
	 boolean actualizarCategoria(int idCategoria, String nombreCategoria, String activoCategoria) throws Exception;

	
	/**
	 * Metodo encargado de eliminar una categoria
	 * @param idCategoria
	 * @return
	 * @throws Exception 
	 */
	 boolean borrarCategoria(int idCategoria) throws Exception;
	
	
	
	/**
	 * Metodo que agrega una nueva categoria
	 * 
	 * @param nombre
	 * @param estado
	 * @return
	 * @throws Exception 
	 */
	 boolean insertarCategoria(String nombre, String estado) throws Exception;

	/**
	 * Metodo que obtiene el listado de categorias
	 * 
	 * @return
	 * @throws Exception 
	 */
	 List<Categoria> obtenerCategorias() throws Exception;

}
