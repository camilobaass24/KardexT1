package com.pruebatecnica.ws.business.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import com.pruebatecnica.ws.business.commons.Constantes.Utilidades;
import com.pruebatecnica.ws.business.dao.AdministrarUsuariosDao;
import com.pruebatecnica.ws.business.dao.conection.Conection;
import com.pruebatecnica.ws.business.vo.Usuario;

public class AdministrarUsuariosDaoJdbc implements AdministrarUsuariosDao {

	private Connection conection;

	public AdministrarUsuariosDaoJdbc() throws Exception {
		conection = Conection.conection();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.pruebatecnica.ws.business.dao.AdministrarUsuariosDao#registrarUsuario
	 * (com.pruebatecnica.ws.business.vo.Usuario)
	 */
	public boolean registrarUsuario(Usuario usuario) throws Exception {
		StringBuilder insertusuario = new StringBuilder();
		insertusuario.append("insert into usuarios (nombre_usuario,rol_usuario,pasword_usuario ) ");
		insertusuario.append("values (?,?,?)");

		try {
			PreparedStatement preparedStatement = conection.prepareStatement(insertusuario.toString());
			preparedStatement.setString(1, usuario.getNombreUsuario());
			preparedStatement.setInt(2, usuario.getIdrol());
			preparedStatement.setString(3, usuario.getPassword());
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			Utilidades.logger.log(Level.INFO, e.toString());
			throw new Exception();
		} finally {
			try {
				if (!conection.isClosed()) {
					conection.close();
				}
			} catch (SQLException e) {
				Utilidades.logger.log(Level.INFO, e.toString());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.pruebatecnica.ws.business.dao.AdministrarUsuariosDao#obtenerUsuarios(
	 * )
	 */
	public List<Usuario> obtenerUsuarios() throws Exception {
		Connection conection = Conection.conection();
		ResultSet resultSet = null;
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		StringBuilder obtenerCategorias = new StringBuilder();
		PreparedStatement preparedStatement;
		obtenerCategorias.append("select id_usuario,  nombre_usuario, rol_usuario, password_usuario from usuarios");
		try {
			preparedStatement = conection.prepareStatement(obtenerCategorias.toString());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				final Usuario usuario = new Usuario();
				usuario.setIdUsuario(resultSet.getInt("id_usuario"));
				usuario.setNombreUsuario(resultSet.getString("nombre_usuario"));
				usuario.setPassword(resultSet.getString("password_usuario"));
				usuario.setIdrol(resultSet.getInt("rol_usuario"));
				listaUsuarios.add(usuario);
			}
			resultSet.close();
			return listaUsuarios;
		} catch (Exception e) {
			Utilidades.logger.log(Level.INFO, e.toString());
			throw new Exception();
		} finally {
			try {
				if (!conection.isClosed()) {
					conection.close();
					resultSet.close();
				}
			} catch (SQLException e) {
				Utilidades.logger.log(Level.INFO, e.toString());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.pruebatecnica.ws.business.dao.AdministrarUsuariosDao#validarUsuario(com.pruebatecnica.ws.business.vo.Usuario)
	 */
	public Usuario validarUsuario(Usuario usuario) throws Exception {

		ResultSet resultSet = null;
		StringBuilder obtenerUsuarios = new StringBuilder();
		obtenerUsuarios.append("select id_usuario,  nombre_usuario, rol_usuario, pasword_usuario from usuarios ");
		obtenerUsuarios.append("where nombre_usuario=? ");
		obtenerUsuarios.append("and pasword_usuario=? ");
		try {
			PreparedStatement preparedStatement = conection.prepareStatement(obtenerUsuarios.toString());
			preparedStatement.setString(1, usuario.getNombreUsuario());
			preparedStatement.setString(2, usuario.getPassword());
			resultSet = preparedStatement.executeQuery();
			preparedStatement.close();
			Usuario usuarioValido = new Usuario();
			while (resultSet.next()) {
			usuarioValido.setIdUsuario(resultSet.getInt("id_usuario"));
			usuarioValido.setNombreUsuario(resultSet.getString("nombre_usuario"));
			usuarioValido.setPassword(resultSet.getString("pasword_usuario"));
			usuario.setIdrol(resultSet.getInt("rol_usuario"));
			}
			resultSet.close();
			return usuarioValido;
		} catch (Exception e) {
			Utilidades.logger.log(Level.INFO, e.toString());
			throw new Exception();
		} finally {
			try {
				if (!conection.isClosed()) {
					conection.close();
				}
			} catch (SQLException e) {
				Utilidades.logger.log(Level.INFO, e.toString());
			}
		}
	}

}