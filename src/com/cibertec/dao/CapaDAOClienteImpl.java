package com.cibertec.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.cibertec.bean.Cliente;
import com.cibertec.bean.Ubigeo;

public class CapaDAOClienteImpl implements CapaDAOCliente{
	
	SqlSessionFactory sqlMapper = null;
	{
		String archivo = "ConfiguracionIbatis.xml";
		try {
			Reader reader = Resources.getResourceAsReader(archivo);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}




	@Override
	public List<Cliente> listaCliente(Cliente filtro) throws Exception {
		List<Cliente> salida = null;
		SqlSession session = null;
		try {
			// Se crea la conexión(Session) a la BD
			session = sqlMapper.openSession();
			// Se aplica al sentecia en la BD
			salida = session.selectList("SQL_lista_cliente", filtro.getCorreo() + "%");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}

	@Override
	public int insertaCliente(Cliente obj) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.insert("SQL_inserta_cliente", obj);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return salida;

	}


	@Override
	public List<Ubigeo> traeDepartamentos() throws Exception {

		List<Ubigeo> salida = null;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.selectList("SQL_lista_departamentos");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;

	}

	@Override
	public List<Ubigeo> traeProvincias(Ubigeo ubigeoBean) throws Exception {
		List<Ubigeo> salida = null;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.selectList("SQL_lista_provincias", ubigeoBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}

	@Override
	public List<Ubigeo> traeDistritos(Ubigeo ubigeoBean) throws Exception {
		List<Ubigeo> salida = null;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.selectList("SQL_lista_distritos", ubigeoBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}



}
