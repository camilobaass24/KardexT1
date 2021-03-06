package com.pruebatecnica.ws.business.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.pruebatecnica.ws.business.commons.Constantes.Utilidades;
import com.pruebatecnica.ws.business.dao.GestionarProductoDao;
import com.pruebatecnica.ws.business.dao.conection.Conection;
import com.pruebatecnica.ws.business.vo.Producto;

public class GestionarProductoDaoJdbc implements GestionarProductoDao {

	private Connection conection;

	public GestionarProductoDaoJdbc() throws Exception {
		conection = Conection.conection();
	}

	public List<Producto> obtenerProductos() throws Exception {
		ResultSet resultSet = null;
		List<Producto> listaProductos = new ArrayList();
		StringBuilder obtenerProductos = new StringBuilder();
		obtenerProductos.append("select  codigo_producto, nombre_producto, id_categoria from productos");
		try {
			PreparedStatement preparedStatement = conection.prepareStatement(obtenerProductos.toString());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				final Producto producto = new Producto();
				producto.setIdCategoria(resultSet.getInt("id_categoria"));
				producto.setCodigoProducto(resultSet.getInt("codigo_producto"));
				producto.setNombreProducto(resultSet.getString("nombre_producto"));
				listaProductos.add(producto);
			}
			resultSet.close();
			return listaProductos;
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

	public boolean registrarProducto(Producto producto) throws Exception {

		conection = Conection.conection();
		StringBuilder registrarProducto = new StringBuilder();
		registrarProducto.append("insert into productos (nombre_producto,id_categoria) ");
		registrarProducto.append("values (?,?)");

		try {
			PreparedStatement preparedStatement = conection.prepareStatement(registrarProducto.toString());
			preparedStatement.setString(1, producto.getNombreProducto());
			preparedStatement.setInt(2, producto.getIdCategoria());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		} catch (Exception e) {
			Utilidades.logger.log(Level.INFO, e.toString());
			throw new Exception();
		} finally {
			try {
				if (conection!=null) {
					conection.close();
				}
			} catch (SQLException e) {
				Utilidades.logger.log(Level.INFO, e.toString());
			}
		}
	}

}
