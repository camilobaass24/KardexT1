package com.pruebatecnica.ws.business.dao;

import java.util.List;

import com.pruebatecnica.ws.business.vo.Usuario;

public interface AdministrarUsuariosDao {
	
	
	/**
	 * metodo que obtiene todos los usuarios
	 * @return
	 * @throws Exception 
	 */
	List<Usuario> obtenerUsuarios() throws Exception;
	/**
	 * Metodo que registra un usuario
	 * @param usuario
	 * @return
	 * @throws Exception 
	 */
	boolean registrarUsuario(Usuario usuario) throws Exception;
	/**
	 * Metodo que valida si es un usuario valido
	 * @param usuario
	 * @return
	 * @throws Exception 
	 */
	Usuario validarUsuario(Usuario usuario) throws Exception;

}
