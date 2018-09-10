package com.pruebatecnica.ws.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.pruebatecnica.ws.business.manager.GestionarProductoManager;
import com.pruebatecnica.ws.business.manager.impl.GestionarProductoManagerImpl;
import com.pruebatecnica.ws.business.vo.Producto;

public class TestProducto {

	private GestionarProductoManager gestionarProductoManager;

	public TestProducto() throws Exception {
		gestionarProductoManager = new GestionarProductoManagerImpl();
	}

	@Test
	public void testRegistrarProductos() {

		Producto producto = new Producto();
		producto.setIdCategoria(1);
		producto.setNombreProducto("Camisetas de Batman");
		assertTrue(gestionarProductoManager.registrarProducto(producto));
	}
	
	@Test
	public void testObtenerProductos() {

		
		List<Producto> productos=gestionarProductoManager.obtenerProductos();
		assertNotSame(productos.size(), 0);
	}
	
	
	

}
