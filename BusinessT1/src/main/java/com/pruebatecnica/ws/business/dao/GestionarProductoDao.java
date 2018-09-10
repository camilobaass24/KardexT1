package com.pruebatecnica.ws.business.dao;

import java.util.List;

import com.pruebatecnica.ws.business.vo.Producto;

public interface GestionarProductoDao {
	
	/**
	 * Metodo que obtiene todos los productos
	 * @return
	 * @throws Exception 
	 */
	List<Producto> obtenerProductos() throws Exception;

	/**
	 * Metodo que registra un producto
	 * @param producto
	 * @return
	 * @throws Exception
	 */
	boolean registrarProducto(Producto producto) throws Exception;

}
