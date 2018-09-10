package com.pruebatecnica.ws.business.vo;

import java.util.Date;

public class Movimiento {

	private int idMovimiento;
	private String detalleMovimiento;
	private Date fechaMovimiento;
	private int idTipoMovimiento;
	private int idProductoMovimiento;
	private int precioUnitario;
	private int total;
	private int cantidad;

	public int getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public String getDetalleMovimiento() {
		return detalleMovimiento;
	}

	public void setDetalleMovimiento(String detalleMovimiento) {
		this.detalleMovimiento = detalleMovimiento;
	}

	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	public int getIdTipoMovimiento() {
		return idTipoMovimiento;
	}

	public void setIdTipoMovimiento(int idTipoMovimiento) {
		this.idTipoMovimiento = idTipoMovimiento;
	}

	public int getIdProductoMovimiento() {
		return idProductoMovimiento;
	}

	public void setIdProductoMovimiento(int idProductoMovimiento) {
		this.idProductoMovimiento = idProductoMovimiento;
	}

	public int getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(int precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}