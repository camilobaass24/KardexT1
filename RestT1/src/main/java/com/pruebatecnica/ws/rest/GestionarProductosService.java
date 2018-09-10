package com.pruebatecnica.ws.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pruebatecnica.ws.business.commons.Constantes.Utilidades;
import com.pruebatecnica.ws.business.manager.GestionarProductoManager;
import com.pruebatecnica.ws.business.manager.impl.GestionarProductoManagerImpl;
import com.pruebatecnica.ws.business.vo.Producto;

@Path("/PruebaTecnica")
public class GestionarProductosService {

	GestionarProductoManager gestionarProductoManager;

	public GestionarProductosService() throws Exception {
		gestionarProductoManager = new GestionarProductoManagerImpl();
	}

	@POST
	@Path("/resgistrarProducto")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Producto resgistrarProducto(Producto producto) {
		try {
			if (gestionarProductoManager.registrarProducto(producto)) {
				return producto;
			}
		} catch (Exception e) {
			Utilidades.logger.log(Level.INFO, e.toString());
			return producto;
		}

		return null;
	}

	/**
	 * Servicio que obtiene todos los productos
	 * 
	 * @return
	 */
	@GET
	@Path("/obtenerProductos")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Producto> obtenerproductos() {
		List<Producto> productos = new ArrayList<Producto>();
		try {
			productos = gestionarProductoManager.obtenerProductos();
			return productos;
		} catch (Exception e) {
			Utilidades.logger.log(Level.INFO, e.toString());
			return productos;
		}

	}
}
