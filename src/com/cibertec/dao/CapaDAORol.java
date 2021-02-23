package com.cibertec.dao;

import java.util.List;

import com.cibertec.bean.Rol;

public interface CapaDAORol {

	//Rol
	public List<Rol> listaRol(String filtro)throws Exception;
	public int insertarRol(Rol r)throws Exception ;	
	public int actualizarRol(Rol c)throws Exception ;	
	public int eliminarRol(int idRol)throws Exception ;	
}
