package com.cibertec.dao;

import java.util.List;

import com.cibertec.bean.Cliente;
import com.cibertec.bean.Ubigeo;

public interface CapaDAOCliente {

	//Consulta de Cliente

	//public abstract List<Ubigeo> listaUbigeo() throws Exception;
	//public abstract int insertarCliente(Cliente c) throws Exception;

	public abstract List<Cliente> listaCliente(Cliente filtro) throws Exception;
	public abstract int insertaCliente(Cliente obj) throws Exception;

	
	
	public abstract List<Ubigeo> traeDepartamentos() throws Exception;

	public abstract List<Ubigeo> traeProvincias(Ubigeo ubigeoBean) throws Exception;

	public abstract List<Ubigeo> traeDistritos(Ubigeo ubigeoBean) throws Exception;

	
}