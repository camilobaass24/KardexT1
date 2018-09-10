package com.pruebatecnica.ws.business.manager.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.pruebatecnica.ws.business.commons.Constantes.Utilidades;
import com.pruebatecnica.ws.business.dao.AdministrarUsuariosDao;
import com.pruebatecnica.ws.business.dao.impl.AdministrarUsuariosDaoJdbc;
import com.pruebatecnica.ws.business.manager.GestionarUsuariosManager;
import com.pruebatecnica.ws.business.vo.Usuario;

public class GestionarUsuariosManagerImpl implements GestionarUsuariosManager {

	private AdministrarUsuariosDao administrarUsuariosDao;

	public GestionarUsuariosManagerImpl() throws Exception {
		administrarUsuariosDao = new AdministrarUsuariosDaoJdbc();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pruebatecnica.ws.business.manager.GestionarUsuariosManager#
	 * registrarUsuario(com.pruebatecnica.ws.business.vo.Usuario)
	 */
	public boolean registrarUsuario(Usuario usuario) throws Exception {
		try {
			if (administrarUsuariosDao.registrarUsuario(usuario)) {
				return true;
			}

		} catch (Exception e) {
			return false;
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pruebatecnica.ws.business.manager.GestionarUsuariosManager#
	 * obtenerUsuarios()
	 */
	public List<Usuario> obtenerUsuarios() throws Exception {

		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {

			usuarios = administrarUsuariosDao.obtenerUsuarios();
			return usuarios;

		} catch (Exception e) {
			return usuarios;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pruebatecnica.ws.business.manager.GestionarUsuariosManager#
	 * validarUsuario(com.pruebatecnica.ws.business.vo.Usuario)
	 */
	public Usuario validarUsuario(Usuario usuario) throws Exception {
		Usuario usuarioValido = new Usuario();
		try {
			if (usuario != null) {
				usuarioValido = administrarUsuariosDao.validarUsuario(usuario);
				return usuarioValido;
			}

		} catch (Exception e) {
			Utilidades.logger.log(Level.INFO, e.toString());
			return usuarioValido;
		}

		return usuarioValido;
	}

}
