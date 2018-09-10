package com.pruebatecnica.ws.rest;

import java.util.logging.Level;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pruebatecnica.ws.business.commons.Constantes.Utilidades;
import com.pruebatecnica.ws.business.manager.GestionarUsuariosManager;
import com.pruebatecnica.ws.business.manager.impl.GestionarUsuariosManagerImpl;
import com.pruebatecnica.ws.business.vo.Usuario;

@Path("/Usuarios")
public class GestionarUsuariosService {
	
	
	
	private GestionarUsuariosManager gestionarUsuariosManager;
	/**
	 * Constructr de la clase
	 * @throws Exception 
	 */
	public GestionarUsuariosService() throws Exception {
		gestionarUsuariosManager = new GestionarUsuariosManagerImpl();
	}
	
	/**
	 * Metodo que resgistra un  usuario
	 * 
	 * @param categoria
	 * @return
	 */
	@POST
	@Path("/resgistrarUsuario")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public boolean registrarCategoria(Usuario usuario) {
		try {
			gestionarUsuariosManager.registrarUsuario(usuario);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	/**
	 * Metodo que resgistra un  usuario
	 * 
	 * @param categoria
	 * @return
	 */
	@POST
	@Path("/validarUsuario")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Usuario validarusuario(Usuario usuario) {
		Usuario usuarioValido= new Usuario();
		try {
			usuarioValido=gestionarUsuariosManager.validarUsuario(usuario);
			return usuarioValido;
		} catch (Exception e) {
			Utilidades.logger.log(Level.INFO, e.toString());
			return usuarioValido;
		}
	}
	

}
