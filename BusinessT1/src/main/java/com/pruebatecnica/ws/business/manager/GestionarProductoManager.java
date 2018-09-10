package com.pruebatecnica.ws.business.manager;

import java.util.List;

import com.pruebatecnica.ws.business.vo.Producto;

public interface GestionarProductoManager {
	
	
	/**
	 * Metodo que registra un producto
	 * @param producto
	 * @return
	 */
	boolean registrarProducto(Producto producto);
	/**
	 * Metodo que obtiene todos los productos
	 * @return
	 */
	List<Producto> obtenerProductos();

}
