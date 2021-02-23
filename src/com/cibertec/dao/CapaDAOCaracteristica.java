package com.cibertec.dao;

import java.util.List;

import com.cibertec.bean.CaracteristicaCliente;

public interface CapaDAOCaracteristica {

	//Caracteristica
	public List<CaracteristicaCliente> listaCaracteristica(String filtro)throws Exception;
	public int insertarCaracteristica(CaracteristicaCliente c)throws Exception ;	
	public int actualizarCaracteristica(CaracteristicaCliente c)throws Exception ;	
	public int eliminarCaracteristica(int idCaracteristica)throws Exception ;	
}
