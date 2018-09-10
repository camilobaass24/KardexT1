package com.pruebatecnica.ws.business.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.springframework.stereotype.Repository;
import com.pruebatecnica.ws.business.commons.Constantes.Utilidades;
import com.pruebatecnica.ws.business.dao.AdministrarRolesDao;
import com.pruebatecnica.ws.business.dao.conection.Conection;
import com.pruebatecnica.ws.business.vo.Rol;

@Repository
public class AdministrarRolesDaoJdbc implements AdministrarRolesDao {
	private Connection conection;

	public AdministrarRolesDaoJdbc() throws Exception {
		conection = Conection.conection();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pruebatecnica.ws.business.dao.AdministrarCategoriasDao#
	 * actualizarCategoria(int)
	 */
	public boolean actualizarRol(int idRol, String nombreRol) throws Exception {

		StringBuilder actualizarRol = new StringBuilder();
		actualizarRol.append("update roles  set nombre_rol=? ");
		actualizarRol.append("where id_rol=?");

		try {
			PreparedStatement preparedStatement = conection.prepareStatement(actualizarRol.toString());
			preparedStatement.setString(1, nombreRol);
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
	 * @see com.pruebatecnica.ws.business.dao.AdministrarCategoriasDao#
	 * borrarCategoria(int)
	 */
	public boolean borrarRol(int idCategoria) throws Exception {
		StringBuilder deleteRol = new StringBuilder();
		deleteRol.append("delete from roles ");
		deleteRol.append("where id_rol=?");

		try {
			PreparedStatement preparedStatement = conection.prepareStatement(deleteRol.toString());
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
	 * @see com.pruebatecnica.ws.business.dao.AdministrarCategoriasDao#
	 * insertarCategoria(java.lang.String, java.lang.String)
	 */
	public boolean insertarRol(String nombre) throws Exception {
		StringBuilder insertRol = new StringBuilder();
		insertRol.append("insert into roles (nombre_rol) ");
		insertRol.append("values (?)");

		try {
			PreparedStatement preparedStatement = conection.prepareStatement(insertRol.toString());
			preparedStatement.setString(1, nombre);
			preparedStatement.executeUpdate();
			preparedStatement.close();
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
	 * @see com.pruebatecnica.ws.business.dao.AdministrarCategoriasDao#
	 * obtenerCategorias()
	 */
	public List<Rol> obtenerRoles() throws Exception {
		ResultSet resultSet = null;
		List<Rol> listaRoles = new ArrayList<Rol>();
		StringBuilder obtenerRoles = new StringBuilder();
		obtenerRoles.append("select  id_rol, nombre_rol from roles");
		try {
			PreparedStatement preparedStatement = conection.prepareStatement(obtenerRoles.toString());
			resultSet = preparedStatement.executeQuery();
			preparedStatement.close();

			while (resultSet.next()) {
				final Rol rol = new Rol();
				rol.setIdRol(resultSet.getInt("id_rol"));
				rol.setNombreRol(resultSet.getString("nombre_rol"));
				listaRoles.add(rol);
			}
			resultSet.close();
			return listaRoles;
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