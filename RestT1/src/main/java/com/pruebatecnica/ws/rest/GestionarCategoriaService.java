package com.pruebatecnica.ws.rest;

import java.util.List;
import java.util.logging.Level;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pruebatecnica.ws.business.commons.Constantes.Utilidades;
import com.pruebatecnica.ws.business.manager.GestionarCategoriaManager;
import com.pruebatecnica.ws.business.manager.impl.GestionarCategoriaManagerImpl;
import com.pruebatecnica.ws.business.vo.Categoria;

@Path("/Categorias")
public class GestionarCategoriaService {

	GestionarCategoriaManager gestionarCategoriaManager;

	/**
	 * Constructr de la clase
	 */
	public GestionarCategoriaService() {
		gestionarCategoriaManager = new GestionarCategoriaManagerImpl();
	}

	/**
	 * Servicio que obtiene todas las categorias
	 * 
	 * @return
	 */
	@GET
	@Path("/obtenerCategorias")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Categoria> obtenerCategorias()

	{
		return gestionarCategoriaManager.obtenerCategorias();
	}

	/**
	 * Metodo que resgitra una categoria
	 * 
	 * @param categoria
	 * @return
	 */
	@POST
	@Path("/resgistrarCategoria")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public boolean registrarCategoria(Categoria categoria) {
		try {
			gestionarCategoriaManager.insertarCategoria(categoria);
			return true;
		} catch (Exception e) {
			Utilidades.logger.log(Level.INFO, e.toString());
			return false;
		}
	}

}
