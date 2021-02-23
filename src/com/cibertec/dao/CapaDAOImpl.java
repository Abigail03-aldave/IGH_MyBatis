package com.cibertec.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.cibertec.bean.CaracteristicaCliente;
import com.cibertec.bean.CaracteristicaProducto;
import com.cibertec.bean.Cliente;
import com.cibertec.bean.Comprobante;
import com.cibertec.bean.ComprobanteDetalle;
import com.cibertec.bean.Marca;
import com.cibertec.bean.Opcion;
import com.cibertec.bean.Pais;
import com.cibertec.bean.Pedido;
import com.cibertec.bean.PedidoDetalle;
import com.cibertec.bean.Producto;
import com.cibertec.bean.Proveedor;
import com.cibertec.bean.Reclamo;
import com.cibertec.bean.Rol;
import com.cibertec.bean.TipoReclamo;
import com.cibertec.bean.Ubigeo;
import com.cibertec.bean.Usuario;

public class CapaDAOImpl implements CapaDAO{

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
	//
	@Override
	public List<Usuario> login(Usuario bean) throws Exception {
		List<Usuario> lista = new ArrayList<Usuario>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("SQL_login", bean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sesion.close();
		}
		return lista;
	}
	
	@Override
	public List<Opcion> traerEnlacesDeUsuario(String idUsuario) throws Exception {
		List<Opcion> lista = new ArrayList<Opcion>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("SQL_traerEnlacesDeUsuario", idUsuario);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sesion.close();
		}
		return lista;
	}
	/*Cliente*/

	@Override
	public List<Cliente> traerClientes() throws Exception {
		List<Cliente> lista = new ArrayList<Cliente>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("SQL_traerClientes");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sesion.close();
		}
		return lista;
	}

	@Override
	public List<Cliente> traerCliente(int idCliente) throws Exception {
		List<Cliente> lista = new ArrayList<Cliente>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("SQL_traerClientes",idCliente);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sesion.close();
		}
		return lista;
	}

	@Override
	public int insertarCliente(Cliente c) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			 session = sqlMapper.openSession();
			 salida = session.insert("SQL_inserta_cliente", c);
			 session.commit();
		} catch (Exception e) {
			 e.printStackTrace();
			 session.rollback();
		} finally{
			 session.close();
		}
		return salida;
	}

	@Override
	public int actualizarCliente(Cliente c) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			 session = sqlMapper.openSession();
			 salida = session.update("SQL_actualizar_cliente", c);
			 session.commit();
		} catch (Exception e) {
			 e.printStackTrace();
			 session.rollback();
		} finally{
			 session.close();
		}
		return salida;
	}

	@Override
	public int eliminarCliente(int idCliente) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			 session = sqlMapper.openSession();
			 salida = session.delete("SQL_eliminar_cliente", idCliente);
			 session.commit();
		} catch (Exception e) {
			 e.printStackTrace();
			 session.rollback();
		} finally{
			 session.close();
		}
		return salida;
	}
//UBIGEO-------------------------------------------------------------------------------------------
	@Override
	public List<Ubigeo> traerUbigeos() throws Exception {
		List<Ubigeo> lista = new ArrayList<Ubigeo>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("SQL_traerUbigeo");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sesion.close();
		}
		return lista;
	}
   
	@Override
	public Ubigeo traerUbigeo(int id) throws Exception {
		Ubigeo u = new Ubigeo();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			u = sesion.selectOne("SQL_traerUbigeoUnico");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sesion.close();
		}
		return u;
	}
	
	

	// ELIMINAR OPCION---------------------------------------------------------------------
	@Override
	public int eliminaOpcion(int idopcion) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			 session = sqlMapper.openSession();
			 salida = session.delete("SQL_elimina_Opcion", idopcion);
			 session.commit();
		} catch (Exception e) {
			 e.printStackTrace();
			 session.rollback();
		} finally{
			 session.close();
		}
		return salida;
	}
	
	
	

	// INSERTAR OPCION---------------------------------------------------------------------
	
	@Override
	public int insertaOpcion(Opcion obj) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			 session = sqlMapper.openSession();
			 salida = session.insert("SQL_inserta_Opcion", obj);
			 session.commit();
		} catch (Exception e) {
			 e.printStackTrace();
			 session.rollback();
		} finally{
			 session.close();
		}
		return salida;
	}
	

	// ACTUALIZAR OPCION---------------------------------------------------------------------
	@Override
	public int actualizaOpcion(Opcion obj) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			 session = sqlMapper.openSession();
			 salida = session.update("SQL_actualiza_Opcion", obj);
			 session.commit();
		} catch (Exception e) {
			 e.printStackTrace();
			 session.rollback();
		} finally{
			 session.close();
		}
		return salida;
	}
	

	// CONSULTA OPCION---------------------------------------------------------------------
	@Override
	public List<Opcion> listaOpcion(String filtro) throws Exception {
		List<Opcion> salida = null;
		SqlSession session = null;
		try {
			//Se crea la conexión(Session) a la BD
			session = sqlMapper.openSession();
			//Se aplica al sentecia en la BD
			salida = session.selectList("SQL_lista_Opcion", filtro+"%");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}
	//Tipo Reclamo---------------------------------------------------------------------------------------
		@Override
		public List<TipoReclamo> traerTipoReclamos() throws Exception {
			List<TipoReclamo> lista = new ArrayList<TipoReclamo>();
			SqlSession sesion = null; 
			try {
				sesion =  sqlMapper.openSession();
				lista = sesion.selectList("SQL_traerTipoReclamos");
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				sesion.close();
			}
			return lista;
		}

		@Override
		public List<TipoReclamo> traerTipoReclamo(String filtro) throws Exception {
			List<TipoReclamo> lista = new ArrayList<TipoReclamo>();
			SqlSession sesion = null; 
			try {
				sesion =  sqlMapper.openSession();
				lista = sesion.selectList("SQL_traerTipoReclamo",filtro+"%");
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				sesion.close();
			}
			return lista;
		}

		@Override
		public int insertarTipoReclamo(TipoReclamo t) throws Exception {
			int salida = -1;
			SqlSession session = null;
			try {
				 session = sqlMapper.openSession();
				 salida = session.insert("SQL_inserta_tiporeclamo", t);
				 session.commit();
			} catch (Exception e) {
				 e.printStackTrace();
				 session.rollback();
			} finally{
				 session.close();
			}
			return salida;
		}

		@Override
		public int actualizarTipoReclamo(TipoReclamo t) throws Exception {
			int salida = -1;
			SqlSession session = null;
			try {
				 session = sqlMapper.openSession();
				 salida = session.update("SQL_actualizar_tiporeclamo", t);
				 session.commit();
			} catch (Exception e) {
				 e.printStackTrace();
				 session.rollback();
			} finally{
				 session.close();
			}
			return salida;
		}

		@Override
		public int eliminarTipoReclamo(int idtipoReclamo) throws Exception {
			int salida = -1;
			SqlSession session = null;
			try {
				 session = sqlMapper.openSession();
				 salida = session.delete("SQL_eliminar_tiporeclamo", idtipoReclamo);
				 session.commit();
			} catch (Exception e) {
				 e.printStackTrace();
				 session.rollback();
			} finally{
				 session.close();
			}
			return salida;
		}		
//Fin Metodos TipoReclamo------------------------------------------------------------------------	
//Inicio Metodos Rol-----------------------------------------------------------------------------		
		@Override
		public List<Rol> listaRol() throws Exception {
			List<Rol> lista = new ArrayList<Rol>();
			SqlSession sesion = null; 
			try {
				sesion =  sqlMapper.openSession();
				lista = sesion.selectList("SQL_lista_rol");
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				sesion.close();
			}
			return lista;
		}

		@Override
		public int insertarRol(Rol r) throws Exception {
			int salida = -1;
			SqlSession session = null;
			try {
				 session = sqlMapper.openSession();
				 salida = session.insert("SQL_inserta_rol", r);
				 session.commit();
			} catch (Exception e) {
				 e.printStackTrace();
				 session.rollback();
			} finally{
				 session.close();
			}
			return salida;
		}

		@Override
		public int actualizarRol(Rol c) throws Exception {
			int salida = -1;
			SqlSession session = null;
			try {
				 session = sqlMapper.openSession();
				 salida = session.update("SQL_actualizar_rol", c);
				 session.commit();
			} catch (Exception e) {
				 e.printStackTrace();
				 session.rollback();
			} finally{
				 session.close();
			}
			return salida;
		}

		@Override
		public int eliminarRol(int idRol) throws Exception {
			int salida = -1;
			SqlSession session = null;
			try {
				 session = sqlMapper.openSession();
				 salida = session.delete("SQL_eliminar_rol", idRol);
				 session.commit();
			} catch (Exception e) {
				 e.printStackTrace();
				 session.rollback();
			} finally{
				 session.close();
			}
			return salida;
		}
		
//Fin Metodos Rol------------------------------------------------------------------------------------------	
//Inicio Metodos Caracteristica-----------------------------------------------------------------------------
		
		@Override
		public List<CaracteristicaCliente> listaCaracteristica() throws Exception {
			List<CaracteristicaCliente> lista = new ArrayList<CaracteristicaCliente>();
			SqlSession sesion = null; 
			try {
				sesion =  sqlMapper.openSession();
				lista = sesion.selectList("SQL_lista_caracteristica");
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				sesion.close();
			}
			return lista;
		}

		@Override
		public int insertarCaracteristica(CaracteristicaCliente c) throws Exception {
			int salida = -1;
			SqlSession session = null;
			try {
				 session = sqlMapper.openSession();
				 salida = session.insert("SQL_inserta_caracteristica", c);
				 session.commit();
			} catch (Exception e) {
				 e.printStackTrace();
				 session.rollback();
			} finally{
				 session.close();
			}
			return salida;
		}

		@Override
		public int actualizarCaracteristica(CaracteristicaCliente c) throws Exception {
			int salida = -1;
			SqlSession session = null;
			try {
				 session = sqlMapper.openSession();
				 salida = session.update("SQL_actualizar_caracteristica", c);
				 session.commit();
			} catch (Exception e) {
				 e.printStackTrace();
				 session.rollback();
			} finally{
				 session.close();
			}
			return salida;
		}

		@Override
		public int eliminarCaracteristica(int idCaracteristica) throws Exception {
			int salida = -1;
			SqlSession session = null;
			try {
				 session = sqlMapper.openSession();
				 salida = session.delete("SQL_eliminar_caracteristica", idCaracteristica);
				 session.commit();
			} catch (Exception e) {
				 e.printStackTrace();
				 session.rollback();
			} finally{
				 session.close();
			}
			return salida;
		}
//Fin Metodos Caracteristica----------------------------------------------------------------------------------------
//Inicio Metodos Pais-----------------------------------------------------------------------------------------------
		
		@Override
		public List<Pais> listaPais(String filtro) throws Exception {
			List<Pais> lista = new ArrayList<Pais>();
			SqlSession sesion = null; 
			try {
				sesion =  sqlMapper.openSession();
				lista = sesion.selectList("SQL_lista_pais",filtro+"%");
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				sesion.close();
			}
			
			return lista;
		}

		@Override
		public int insertarPais(Pais p) throws Exception {
			int salida = -1;
			SqlSession session = null;
			try {
				 session = sqlMapper.openSession();
				 salida = session.insert("SQL_inserta_pais", p);
				 session.commit();
			} catch (Exception e) {
				 e.printStackTrace();
				 session.rollback();
			} finally{
				 session.close();
			}
			return salida;
		}

		@Override
		public int actualizarPais(Pais p) throws Exception {
			int salida = -1;
			SqlSession session = null;
			try {
				 session = sqlMapper.openSession();
				 salida = session.update("SQL_actualizar_pais", p);
				 session.commit();
			} catch (Exception e) {
				 e.printStackTrace();
				 session.rollback();
			} finally{
				 session.close();
			}
			
			return salida;
		}

		@Override
		public int eliminarPais(int idPais) throws Exception {
			int salida = -1;
			SqlSession session = null;
			try {
				 session = sqlMapper.openSession();
				 salida = session.delete("SQL_eliminar_pais", idPais);
				 session.commit();
			} catch (Exception e) {
				 e.printStackTrace();
				 session.rollback();
			} finally{
				 session.close();
			}		
			return salida;
		}
		//Inicio Marca
				@Override
				public List<Marca> listaMarca(String filtro) throws Exception{
					List<Marca> lista = new ArrayList<Marca>();
					SqlSession sesion = null; 
					try {
						sesion =  sqlMapper.openSession();
						lista = sesion.selectList("SQL_lista_marca",filtro+"%");
					} catch (Exception e) {
						e.printStackTrace();
					} finally{
						sesion.close();
					}
					return lista;
				}
				
				@Override
				public int insertarMarca(Marca m) throws Exception {
					int salida = -1;
					SqlSession session = null;
					try {
						 session = sqlMapper.openSession();
						 salida = session.insert("SQL_insertar_marca", m);
						 session.commit();
					} catch (Exception e) {
						 e.printStackTrace();
						 session.rollback();
					} finally{
						 session.close();
					}
					return salida;
				}

				@Override
				public int actualizarMarca(Marca m) throws Exception {
					int salida = -1;
					SqlSession session = null;
					try {
						 session = sqlMapper.openSession();
						 salida = session.update("SQL_actualizar_marca", m);
						 session.commit();
					} catch (Exception e) {
						 e.printStackTrace();
						 session.rollback();
					} finally{
						 session.close();
					}
					return salida;
				}

				@Override
				public int eliminarMarca(int idMarca) throws Exception {
					int salida = -1;
					SqlSession session = null;
					try {
						 session = sqlMapper.openSession();
						 salida = session.delete("SQL_eliminar_marca", idMarca);
						 session.commit();
					} catch (Exception e) {
						 e.printStackTrace();
						 session.rollback();
					} finally{
						 session.close();
					}
					return salida;
				}
				@Override
				public List<Pais> listaTodosPais() throws Exception {
					SqlSession session = null;
					List<Pais> salida = null;
					try {
						session = sqlMapper.openSession();
						salida = session.selectList("SQL_lista_pais_combo");
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						session.close();
					}
					return salida;
				}
//Comprobante-------------------------------------------------------------------------------------
	@Override
	public List<Pedido> listaPedido() throws Exception {
		List<Pedido> lista = new ArrayList<Pedido>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("sql_listarPedido");
		} catch (Exception e) {e.printStackTrace();} 
		finally{sesion.close();}
		return lista;
	}
	@Override
	public List<Comprobante> listaComprobante(String filtro) throws Exception {
		List<Comprobante> lista = new ArrayList<Comprobante>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("SQL_traerComprobante");
		} catch (Exception e) {e.printStackTrace();} 
		finally{sesion.close();}
		return lista;
	}
	@Override
	public int insertarComprobante(Comprobante c) throws Exception {
		SqlSession session = sqlMapper.openSession();
		int salida=0;
		try {
			salida=session.insert("sql_insertaComprobanteCabecera",c);
			int id = c.getIdcomprobante();
			List<ComprobanteDetalle> detalle = c.getDetalle();
			for (ComprobanteDetalle x : detalle) {
				x.setIdcomprobante(id);
				salida += session.insert("sql_insertaComprobanteDetalle",x);
			}
			session.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {session.close();}
		return salida;
	}
	@Override
	public List<Producto> listaProducto() throws Exception {
		List<Producto> lista = new ArrayList<Producto>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("sql_listarProducto");
		} catch (Exception e) {e.printStackTrace();}
		finally{sesion.close();}
		return lista;
	}
	@Override
	public List<Producto> listaProductoPor(String filtro) throws Exception {
		List<Producto> lista = new ArrayList<Producto>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("sql_listarProductoPor",filtro+"%");
		}catch (Exception e) {e.printStackTrace();} 
		finally{sesion.close();}
		return lista;
	}
	@Override
	public List<Pedido> listaPedidoPor(String filtro) throws Exception {
		List<Pedido> lista = new ArrayList<Pedido>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("sql_listarPedidoPor",filtro+"%");
		}catch (Exception e) {e.printStackTrace();} 
		finally{sesion.close();}
		return lista;
	}
	
	//CONSULTAR COMPROBANTE RE ===========================================================================

		@Override
			public List<Comprobante> listaComprobantePorFiltro(Comprobante c) throws Exception {
				List<Comprobante> lista = null;
				SqlSession session = null;
				try {
					session = sqlMapper.openSession();
					lista = session.selectList("SQL_lista_comprobante", c);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					session.close();
				}
				return lista;
				
			}
			
			
		/*			
			  		@Override
			public int insertaComprobante(Comprobante c) throws Exception {
				int salida = -1;
				SqlSession session = null;
				try {
					session = sqlMapper.openSession();
					salida = session.insert("SQL_inserta_comprobante", c);
					session.commit();
				} catch (Exception e) {
					e.printStackTrace();
					session.rollback();
				} finally {
					session.close();
				}
				return salida;
			}

			 */
	
	//Proveedor-------------------------------------------------------------------------------------
	@Override
	public List<Proveedor> listaProveedor(String filtro) throws Exception {
		List<Proveedor> lista = new ArrayList<Proveedor>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("SQL_traerProveedor",filtro+"%");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sesion.close();
		}
		return lista;
	}

	@Override
	public int insertarProveedor(Proveedor p) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			 session = sqlMapper.openSession();
			 salida = session.insert("SQL_inserta_proveedor", p);
			 session.commit();
		} catch (Exception e) {
			 e.printStackTrace();
			 session.rollback();
		} finally{
			 session.close();
		}
		return salida;

	}

	@Override
	public int actualizarProveedor(Proveedor p) throws Exception {
			int salida = -1;
			SqlSession session = null;
			try {
				 session = sqlMapper.openSession();
				 salida = session.update("SQL_actualizar_proveedor", p);
				 session.commit();
			} catch (Exception e) {
				 e.printStackTrace();
				 session.rollback();
			} finally{
				 session.close();
			}
			return salida;
	}

	@Override
	public int eliminarProveedor(int idProveedor) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			 session = sqlMapper.openSession();
			 salida = session.delete("SQL_eliminar_proveedor", idProveedor);
			 session.commit();
		} catch (Exception e) {
			 e.printStackTrace();
			 session.rollback();
		} finally{
			 session.close();
		}
		return salida;
	}
	//Pedido-------------------------------------------------------------------------------------
	@Override
	public List<Cliente> listaCliente() throws Exception {
		List<Cliente> lista = new ArrayList<Cliente>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("sql_listarCliente");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sesion.close();
		}
		return lista;
	}

	@Override
	public List<Pedido> listaPedido(String filtro) throws Exception {
		List<Pedido> lista = new ArrayList<Pedido>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("SQL_traerPedido");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sesion.close();
		}
		return lista;
	}

	@Override
	public List<Producto> listaProd() throws Exception {
		List<Producto> lista = new ArrayList<Producto>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("sql_listarProducto");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sesion.close();
		}
		return lista;
	}

	@Override
	public List<Producto> listaProducPor(String filtro) throws Exception {
		List<Producto> lista = new ArrayList<Producto>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("sql_listarProductoPor",filtro+"%");
		}catch (Exception e) {e.printStackTrace();} 
		finally{sesion.close();}
		return lista;
	}

	@Override
	public List<Cliente> listaClientePor(String filtro) throws Exception {
		List<Cliente> lista = new ArrayList<Cliente>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("sql_listarClientePor",filtro+"%");
		}catch (Exception e) {e.printStackTrace();} 
		finally{sesion.close();}
		return lista;
	}

	@Override
	public int insertarPedido(Pedido p) throws Exception {
		SqlSession session = sqlMapper.openSession();
		int salida=0;
		try {
			salida=session.insert("sql_insertaPedidoCabecera",p);
			int id = p.getIdpedido();
			List<PedidoDetalle> detalle = p.getDetalles();
			for (PedidoDetalle x : detalle) {
				x.setIdpedido(id);
				salida += session.insert("sql_insertaPedidoDetalle",x);
			}
			session.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {session.close();}
		return salida;
	}
	//Reclamo-------------------------------------------------------------------------------------
		@Override
		public List<Pedido> listarPedido() throws Exception {
			List<Pedido> lista = new ArrayList<Pedido>();
			SqlSession sesion = null; 
			try {
				sesion =  sqlMapper.openSession();
				lista = sesion.selectList("sql_listarPedido");
			} catch (Exception e) {e.printStackTrace();} 
			finally{sesion.close();}
			return lista;
		}
		@Override
		public List<Cliente> listarCliente() throws Exception {
			List<Cliente> lista = new ArrayList<Cliente>();
			SqlSession sesion = null; 
			try {
				sesion =  sqlMapper.openSession();
				lista = sesion.selectList("sql_listarCliente");
			} catch (Exception e) {e.printStackTrace();} 
			finally{sesion.close();}
			return lista;
		}
		@Override
		public List<TipoReclamo> listarTipoReclamo() throws Exception {
			List<TipoReclamo> lista = new ArrayList<TipoReclamo>();
			SqlSession sesion = null; 
			try {
				sesion =  sqlMapper.openSession();
				lista = sesion.selectList("sql_listarTipoReclamo");
			} catch (Exception e) {e.printStackTrace();} 
			finally{sesion.close();}
			return lista;
		}
		@Override
		public List<Pedido> listarPedidoPor(String filtro) throws Exception {
			List<Pedido> lista = new ArrayList<Pedido>();
			SqlSession sesion = null; 
			try {
				sesion =  sqlMapper.openSession();
				lista = sesion.selectList("sql_listarPedidoPor",filtro+"%");
			}catch (Exception e) {e.printStackTrace();} 
			finally{sesion.close();}
			return lista;
		}
		@Override
		public List<Cliente> listarClientePor(String filtro) throws Exception {
			List<Cliente> lista = new ArrayList<Cliente>();
			SqlSession sesion = null; 
			try {
				sesion =  sqlMapper.openSession();
				lista = sesion.selectList("sql_listarClientePor",filtro+"%");
			}catch (Exception e) {e.printStackTrace();} 
			finally{sesion.close();}
			return lista;
		}
		@Override
		public List<TipoReclamo> listarTipoReclamoPor(String filtro) throws Exception {
			List<TipoReclamo> lista = new ArrayList<TipoReclamo>();
			SqlSession sesion = null; 
			try {
				sesion =  sqlMapper.openSession();
				lista = sesion.selectList("SQL_traerTipoReclamo",filtro+"%");
			}catch (Exception e) {e.printStackTrace();} 
			finally{sesion.close();}
			return lista;
		}
		@Override
		public int insertarReclamo(Reclamo r) throws Exception {
			SqlSession session = sqlMapper.openSession();
			int salida=0;
			try {
				salida=session.insert("sql_insertaReclamo",r);
				int id = r.getIdreclamo();
				
				session.commit();			
			} catch (Exception e) {
				e.printStackTrace();
				session.rollback();
			} finally {session.close();}
			return salida;
		}
		@Override
		public List<Reclamo> listaReclamo(Reclamo filtro) throws Exception {
			List<Reclamo> salida = null;
			SqlSession session = null;
			try {
				// Se crea la conexión(Session) a la BD
				session = sqlMapper.openSession();
				// Se aplica al sentecia en la BD
				salida = session.selectList("sql_listarReclamoPor", filtro.getDescripcion() + "%");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return salida;
		}
		//Producto-------------------------------------------------------------------------------------

		@Override
		public List<Producto> listaProducto(String filtro) throws Exception {
			SqlSession session = null;
			List<Producto> salida = null;
			try {
				session = sqlMapper.openSession();
				salida = session.selectList("sql_listarProductoPor", filtro+"%")  ;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return salida;
		}

		@Override
		public int actualizaProducto(Producto bean) throws Exception {
			int salida = -1;
			SqlSession session = null;
			try {
				 session = sqlMapper.openSession();
				 salida = session.update("SQL_actualiza_Producto", bean);
				 session.commit();
			} catch (Exception e) {
				 e.printStackTrace();
				 session.rollback();
			} finally{
				 session.close();
			}
			return salida;
		}

		@Override
		public int insertaProducto(Producto bean) throws Exception {
			int salida = -1;
			SqlSession session = null;
			try {
				 session = sqlMapper.openSession();
				 salida = session.insert("SQL_inserta_producto", bean);
				 session.commit();
			} catch (Exception e) {
				 e.printStackTrace();
				 session.rollback();
			} finally{
				 session.close();
			}
			return salida;
		}

		@Override
		public int eliminaProducto(int idProducto) throws Exception {
			int salida = -1;
			SqlSession session = null;
			try {
				 session = sqlMapper.openSession();
				 salida = session.delete("SQL_elimina_Producto", idProducto);
				 session.commit();
			} catch (Exception e) {
				 e.printStackTrace();
				 session.rollback();
			} finally{
				 session.close();
			}
			return salida;
		}

		@Override
		public List<Marca> listaMarca() throws Exception {
			SqlSession session = null;
			List<Marca> salida = null;
			try {
				session = sqlMapper.openSession();
				salida = session.selectList("SQL_lista_marca");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return salida;
		}

		@Override
		public List<Pais> listaPais() throws Exception {
			SqlSession session = null;
			List<Pais> salida = null;
			try {
				session = sqlMapper.openSession();
				salida = session.selectList("SQL_lista_pais");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return salida;
		}

		@Override
		public List<Producto> listaProducto(Producto filtro) throws Exception {
			SqlSession session = null;
			List<Producto> salida = null;
			try {
				session = sqlMapper.openSession();
				filtro.setNombre(filtro.getNombre()+"%");
				salida = session.selectList("SQL_listaModalidadPorFiltro",filtro );
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return salida;
		}

		@Override
		public List<Producto> listaModalidadMultiple(Producto filtro) throws Exception {
			SqlSession session = null;
			List<Producto> salida = null;
			try {
				session = sqlMapper.openSession();
				salida = session.selectList("SQL_listaModalidadMultiple",filtro);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return salida;
		}

		@Override
		public List<Usuario> listaUsuario() throws Exception {
			List<Usuario> lista = new ArrayList<Usuario>();
			SqlSession sesion = null; 
			try {
				sesion =  sqlMapper.openSession();
				lista = sesion.selectList("SQL_traerUsuarios");
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				sesion.close();
			}
			return lista;
		}

		@Override
		public int insertaPedido(Pedido bean) throws Exception {
			SqlSession session = sqlMapper.openSession();
			int salida = 0;
			try {
				//Para insertar la cabecera
				salida = session.insert("SQL_insertaPedidoCabecera", bean);
				
				//regresa el id generado
				int id = bean.getIdpedido();
				
				//Se obtiene los detalles
				List<PedidoDetalle> detalles = bean.getDetalles();
				
				//Se insertar los detalles
				for (PedidoDetalle x : detalles) {
					x.setIdpedido(id);
					salida += session.insert("SQL_insertaPedidoDetalle", x);
				}
				
				//Se envia todos los SQL
				session.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
				session.rollback();
			} finally {
				session.close();
			}
			return salida;
		}

		

		@Override@SuppressWarnings({ "rawtypes", "unchecked" })
		public List<Cliente> traeClientePorNombre(String filtro) throws Exception {
			SqlSession session = sqlMapper.openSession();
			List lista = new ArrayList<Cliente>();
			try {
				lista =session.selectList("SQL_traeClientes", filtro+"%");
				return lista;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return null;
		}
		@Override@SuppressWarnings({ "rawtypes", "unchecked" })
		public List<Ubigeo> traeUbigeoPorNombre(String filtro) throws Exception {
			SqlSession session = sqlMapper.openSession();
			List lista = new ArrayList<Cliente>();
			try {
				lista =session.selectList("SQL_traeUbigeo", filtro+"%");
				return lista;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return null;
		}
		@Override@SuppressWarnings({ "rawtypes", "unchecked" })
		public List<Producto> traeProductoPorNombre(String filtro) throws Exception {
			SqlSession session = sqlMapper.openSession();
			List lista = new ArrayList<Producto>();
			try {
				lista =session.selectList("SQL_traeProductos", filtro+"%");
				return lista;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return null;
		}
		@Override
		public List<CaracteristicaProducto> listaCatacteristica() throws Exception {
			List<CaracteristicaProducto> salida = null;
			SqlSession session = null;
			try {
				session = sqlMapper.openSession();
				salida = session.selectList("SQL_lista_caracteristica_producto");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return salida;
		}
		
}
