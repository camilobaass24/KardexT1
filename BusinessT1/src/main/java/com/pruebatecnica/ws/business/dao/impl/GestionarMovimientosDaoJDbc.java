package com.pruebatecnica.ws.business.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.pruebatecnica.ws.business.commons.Constantes.Utilidades;
import com.pruebatecnica.ws.business.dao.GestionarMovimientosDao;
import com.pruebatecnica.ws.business.dao.conection.Conection;
import com.pruebatecnica.ws.business.vo.Movimiento;

public class GestionarMovimientosDaoJDbc implements GestionarMovimientosDao {

	private Connection conection;

	public GestionarMovimientosDaoJDbc() throws Exception {
		conection = Conection.conection();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pruebatecnica.ws.business.dao.GestionarMovimientosDao#
	 * registrarMovimiento(com.pruebatecnica.ws.business.vo.Movimiento)
	 */
	public boolean registrarMovimiento(Movimiento movimiento) throws Exception {

		StringBuilder insertMovmiento = new StringBuilder();
		insertMovmiento.append("insert into movimientos ");
		insertMovmiento.append("(detalle_movimiento, ");
		insertMovmiento.append("fecha_movimiento, ");
		insertMovmiento.append("tipo_movimiento, ");
		insertMovmiento.append("producto_movimiento, ");
		insertMovmiento.append("precio_unitario, ");
		insertMovmiento.append("total, ");
		insertMovmiento.append("cantidad) ");
		insertMovmiento.append("values (?,?,?,?,?,?,?)");

		try {
			PreparedStatement preparedStatement = conection.prepareStatement(insertMovmiento.toString());
			preparedStatement.setString(1, movimiento.getDetalleMovimiento());
			preparedStatement.setDate(2, (Date) movimiento.getFechaMovimiento());
			preparedStatement.setInt(3, movimiento.getIdTipoMovimiento());
			preparedStatement.setInt(4, movimiento.getIdProductoMovimiento());
			preparedStatement.setInt(5, movimiento.getPrecioUnitario());
			preparedStatement.setInt(6, movimiento.getTotal());
			preparedStatement.setInt(7, movimiento.getCantidad());
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
	 * @see com.pruebatecnica.ws.business.dao.GestionarMovimientosDao#obtenerMovimientosPorProducto(com.pruebatecnica.ws.business.vo.Movimiento)
	 */
	public List<Movimiento> obtenerMovimientosPorProducto(Movimiento movimiento) throws Exception {
		ResultSet resultSet = null;
		List<Movimiento> listaMovimientos = new ArrayList();
		StringBuilder obtenerMovimientos = new StringBuilder();
		obtenerMovimientos.append("SELECT id_movimiento, ");
		obtenerMovimientos.append("tipo_movimiento, ");
		obtenerMovimientos.append("producto_movimiento, ");
		obtenerMovimientos.append("detalle_movimiento, ");
		obtenerMovimientos.append("cantidad ");
		obtenerMovimientos.append("FROM movimientos ");
		obtenerMovimientos.append("where producto_movimiento= ? ");
		
		
		try {
			PreparedStatement preparedStatement = conection.prepareStatement(obtenerMovimientos.toString());
			preparedStatement.setInt(1,movimiento.getIdProductoMovimiento());
			resultSet = preparedStatement.executeQuery();
			preparedStatement.close();
			while (resultSet.next()) {
				final Movimiento movimientoProducto = new Movimiento();
				movimientoProducto.setIdMovimiento(resultSet.getInt("id_movimiento"));
				movimientoProducto.setIdTipoMovimiento(resultSet.getInt("tipo_movimiento"));
				movimientoProducto.setIdProductoMovimiento(resultSet.getInt("producto_movimiento"));
				movimientoProducto.setCantidad(resultSet.getInt("cantidad"));
				listaMovimientos.add(movimientoProducto);
			}
			resultSet.close();
			return listaMovimientos;
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
