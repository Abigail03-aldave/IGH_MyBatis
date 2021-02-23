package com.cibertec.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rol {
	private int idRol;
	private String nombre;
	private String estado;
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
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
