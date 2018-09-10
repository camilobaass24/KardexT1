package com.pruebatecnica.ws.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.logging.Level;
import org.junit.Test;
import com.pruebatecnica.ws.business.commons.Constantes.Utilidades;
import com.pruebatecnica.ws.business.manager.GestionarCategoriaManager;
import com.pruebatecnica.ws.business.manager.impl.GestionarCategoriaManagerImpl;
import com.pruebatecnica.ws.business.vo.Categoria;

public class TestCategoria {

	GestionarCategoriaManager gestionarCategoriaManager;

	public TestCategoria() {
		gestionarCategoriaManager = new GestionarCategoriaManagerImpl();
	}

	@Test
	public void testRegistrarCategoria() {

		try {

			Categoria categoria = new Categoria();
			categoria.setNombre("Vasos");
			categoria.setActivo(Utilidades.SI);
			assertTrue(gestionarCategoriaManager.insertarCategoria(categoria));
		} catch (Exception e) {
			Utilidades.logger.log(Level.INFO, e.toString());
		}

	}

	@Test
	public void testObtenerCategorias() {

		try {
			List<Categoria> categorias = gestionarCategoriaManager.obtenerCategorias();
			assertNotSame(categorias.size(), 0);

		} catch (Exception e) {
			
			Utilidades.logger.log(Level.INFO, e.toString());
		}

	}

}
