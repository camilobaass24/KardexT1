package com.pruebatecnica.ws.business.vo;

public class Categoria {

	private int idCategoria;
	private String nombre;
	private String activo;
	
	public Categoria()
	{
		super();
	}
	
	public int getIdCategoria() {
		return idCategoria;
	}



	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}			
	
}
