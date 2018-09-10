package com.pruebatecnica.ws.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.pruebatecnica.ws.business.manager.GestionarProductoManager;
import com.pruebatecnica.ws.business.manager.impl.GestionarProductoManagerImpl;
import com.pruebatecnica.ws.business.vo.Categoria;
import com.pruebatecnica.ws.business.vo.Producto;

@Path("/PruebaTecnica")
public class GestionarProductosService {
	
	GestionarProductoManager gestionarProductoManager;
	
	public GestionarProductosService()
	{
		gestionarProductoManager= new GestionarProductoManagerImpl();
	}
	
	

	@POST
	@Path("/resgistrarProducto")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces ({MediaType.APPLICATION_JSON})
	public Producto resgistrarProducto(Producto producto) {
		try
		{					
			if (gestionarProductoManager.registrarProducto(producto)) {
				return producto;
			}
		}catch(Exception e)
		{
			return producto;
		}
		
		return  null;
	}
	
	/**
	 * Servicio que obtiene todos los productos
	 * 
	 * @return
	 */
	@GET
	@Path("/obtenerCategorias")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Categoria> obtenerCategorias()

	{
		return gestionarProductoManager.obtenerProductos();
	}
}
