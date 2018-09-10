package com.pruebatecnica.ws.business.dao;

import java.util.List;

import com.pruebatecnica.ws.business.vo.Movimiento;

public interface GestionarMovimientosDao {

	
	
	/**
	 * Metodo que obtiene todos los movimientos por producto
	 * @return
	 * @throws Exception 
	 */
	public List<Movimiento> obtenerMovimientosPorProducto(Movimiento movimiento) throws Exception;


	/**
	 * Metodo que registra un movimiento sobre el inventario
	 * @param movimiento
	 * @return
	 * @throws Exception
	 */
	public boolean registrarMovimiento(Movimiento movimiento) throws Exception;

}
