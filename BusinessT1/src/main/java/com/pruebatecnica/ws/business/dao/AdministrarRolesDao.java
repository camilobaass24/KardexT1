package com.pruebatecnica.ws.business.dao;

import java.util.List;
import com.pruebatecnica.ws.business.vo.Rol;

public interface AdministrarRolesDao {

	/**
	 * Metodo que actualiza una categoria
	 * 
	 * @param idCategoria
	 * @return
	 * @throws Exception 
	 */
	 boolean actualizarRol(int idCategoria, String nombreRol) throws Exception;

	
	/**
	 * Metodo encargado de eliminar una categoria
	 * @param idCategoria
	 * @return
	 * @throws Exception 
	 */
	 boolean borrarRol(int idRol) throws Exception;
	
	
	
	/**
	 * Metodo que agrega una nueva categoria
	 * 
	 * @param nombre
	 * @param estado
	 * @return
	 * @throws Exception 
	 */
	 boolean insertarRol(String nombre) throws Exception;

	/**
	 * Metodo que obtiene el listado de categorias
	 * 
	 * @return
	 * @throws Exception 
	 */
	 List<Rol> obtenerRoles() throws Exception;

}
