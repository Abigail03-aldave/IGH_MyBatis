package com.cibertec.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaracteristicaCliente {
	private int idCaracteristica;
	private String nombre;
	private String estado;
	public int getIdCaracteristica() {
		return idCaracteristica;
	}
	public void setIdCaracteristica(int idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	

}
