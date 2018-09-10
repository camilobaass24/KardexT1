package com.pruebatecnica.ws.rest;

import java.util.logging.Level;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pruebatecnica.ws.business.commons.Constantes.Utilidades;
import com.pruebatecnica.ws.business.manager.GestionarMovimientosManager;
import com.pruebatecnica.ws.business.manager.impl.GestionarMovmientosManagerImpl;
import com.pruebatecnica.ws.business.vo.Movimiento;

@Path("/Movimientos")
public class GestionarMovimientosService {

	GestionarMovimientosManager gestionarMovimientosManager;

	public GestionarMovimientosService() throws Exception {

		gestionarMovimientosManager = new GestionarMovmientosManagerImpl();
	}

	@POST
	@Path("/resgistrarMovimiento")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public boolean resgistrarMovimiento(Movimiento mvnto) {
		try {
			if (gestionarMovimientosManager.registrarMovmiento(mvnto)) {
				return true;
			}
		} catch (Exception e) {
			Utilidades.logger.log(Level.INFO, e.toString());
			return false;
		}

		return false;
	}

}
