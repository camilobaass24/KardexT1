package com.pruebatecnica.ws.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.pruebatecnica.ws.business.manager.GestionarMovimientosManager;
import com.pruebatecnica.ws.business.manager.impl.GestionarMovmientosManagerImpl;
import com.pruebatecnica.ws.business.vo.Movimiento;

public class TestMovimientos {

	private GestionarMovimientosManager gestionarMovimientosManager;

	public TestMovimientos() throws Exception {
		gestionarMovimientosManager = new GestionarMovmientosManagerImpl();

	}

	@Test
	public void testRegistrarMovimientos() {
		Movimiento movimiento = new Movimiento();
		movimiento.setDetalleMovimiento("Compra vasos de hulk");
		movimiento.setFechaMovimiento(new Date());
		movimiento.setIdProductoMovimiento(1);
		movimiento.setIdTipoMovimiento(1);
		movimiento.setPrecioUnitario(50000);
		movimiento.setCantidad(50);
		assertTrue(gestionarMovimientosManager.registrarMovmiento(movimiento));
	}

}
