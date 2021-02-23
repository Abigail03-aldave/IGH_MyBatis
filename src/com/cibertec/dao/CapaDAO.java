package com.cibertec.dao;

import java.util.List;

import com.cibertec.bean.CaracteristicaCliente;
import com.cibertec.bean.CaracteristicaProducto;
import com.cibertec.bean.Cliente;
import com.cibertec.bean.Comprobante;
import com.cibertec.bean.Marca;
import com.cibertec.bean.Opcion;
import com.cibertec.bean.Pais;
import com.cibertec.bean.Pedido;
import com.cibertec.bean.Producto;
import com.cibertec.bean.Proveedor;
import com.cibertec.bean.Reclamo;
import com.cibertec.bean.Rol;
import com.cibertec.bean.TipoReclamo;
import com.cibertec.bean.Ubigeo;
import com.cibertec.bean.Usuario;

public interface CapaDAO {	
	//Seguridad
	public List<Usuario> login(Usuario bean) throws Exception;
	public List<Opcion> traerEnlacesDeUsuario(String idUsuario)	throws Exception ;
	//Cliente
	public List<Cliente> traerClientes()throws Exception ;	
	public List<Cliente> traerCliente(int idCliente)throws Exception ;	
	public int insertarCliente(Cliente c)throws Exception ;	
	public int actualizarCliente(Cliente c)throws Exception ;	
	public int eliminarCliente(int idCliente)throws Exception ;	
	//Ubigeo
	public List<Ubigeo> traerUbigeos()throws Exception ;
	public Ubigeo traerUbigeo(int id)throws Exception ;
	//Opcion	
	public abstract int eliminaOpcion(int idopcion) throws Exception;
	public abstract int insertaOpcion(Opcion obj) throws Exception;
	public abstract int actualizaOpcion(Opcion obj) throws Exception;
	public abstract List<Opcion> listaOpcion(String filtro) throws Exception;	
	//Tipo Reclamo
	public List<TipoReclamo> traerTipoReclamos()throws Exception ;	
	public List<TipoReclamo> traerTipoReclamo(String filtro)throws Exception ;	
	public int insertarTipoReclamo(TipoReclamo t)throws Exception ;	
	public int actualizarTipoReclamo(TipoReclamo t)throws Exception ;	
	public int eliminarTipoReclamo(int idtipoReclamo)throws Exception ;
	//Caracteristica
	public List<CaracteristicaCliente> listaCaracteristica()throws Exception;
	public int insertarCaracteristica(CaracteristicaCliente c)throws Exception ;	
	public int actualizarCaracteristica(CaracteristicaCliente c)throws Exception ;	
	public int eliminarCaracteristica(int idCaracteristica)throws Exception ;	
	//Rol
	public List<Rol> listaRol()throws Exception;
	public int insertarRol(Rol r)throws Exception ;	
	public int actualizarRol(Rol c)throws Exception ;	
	public int eliminarRol(int idRol)throws Exception ;	
	//Pais
	public List<Pais> listaPais(String filtro)throws Exception;
	public int insertarPais(Pais p)throws Exception;
	public int actualizarPais(Pais p)throws Exception;
	public int eliminarPais(int idPais)throws Exception;
	//Marca
	public List<Marca> listaMarca(String filtro)throws Exception;
	public List<Pais> listaTodosPais() throws Exception;
	public int insertarMarca(Marca m)throws Exception;
	public int actualizarMarca(Marca m)throws Exception;
	public int eliminarMarca(int idMarca)throws Exception;
	//Comprobante
	public List<Pedido> listaPedido()throws Exception;
	public List<Comprobante> listaComprobante(String filtro)throws Exception;
	public List<Producto> listaProducto()throws Exception;
	public List<Producto> listaProductoPor(String filtro)throws Exception;
	public List<Pedido> listaPedidoPor(String filtro)throws Exception;
	public int insertarComprobante(Comprobante c)throws Exception;
	
	//Añadiendo el Listar en consulta Comprobante RE
	public List<Comprobante> listaComprobantePorFiltro(Comprobante c)throws Exception;

	//Pedido 
	public List<Cliente> listaCliente()throws Exception;
	public List<Pedido> listaPedido(String filtro)throws Exception;
	public List<Producto> listaProd()throws Exception;
	public List<Producto> listaProducPor(String filtro)throws Exception;
	public List<Cliente> listaClientePor(String filtro)throws Exception;
	public int insertarPedido(Pedido p)throws Exception;	
	//Proveedor 
	public List<Proveedor> listaProveedor(String filtro)throws Exception;
	public int insertarProveedor(Proveedor p)throws Exception ;	
	public int actualizarProveedor(Proveedor p)throws Exception ;	
	public int eliminarProveedor(int idProveedor)throws Exception ;
	//Reclamo
	public List<Pedido> listarPedido()throws Exception;
	public List<Cliente> listarCliente()throws Exception;
	public List<TipoReclamo> listarTipoReclamo()throws Exception;
	public List<Pedido> listarPedidoPor(String filtro)throws Exception;
	public List<Cliente> listarClientePor(String filtro)throws Exception;
	public List<TipoReclamo> listarTipoReclamoPor(String filtro)throws Exception;
	public abstract List<Reclamo> listaReclamo(Reclamo filtro) throws Exception;
	public int insertarReclamo(Reclamo r)throws Exception;	
	
	//Producto
	
	public List<Producto> listaProducto(String filtro) throws Exception;
	public int actualizaProducto(Producto bean) throws Exception;
	public int insertaProducto(Producto bean) throws Exception;
	public int eliminaProducto(int idProducto) throws Exception;
	public List<Marca> listaMarca() throws Exception;
	public List<Pais> listaPais() throws Exception;	
	public List<Producto> listaProducto(Producto filtro)  throws Exception;
	public List<Producto> listaModalidadMultiple(Producto filtro)  throws Exception;
	
	public List<Usuario> listaUsuario() throws Exception;
	
	public abstract int insertaPedido (Pedido pedido) throws Exception;
	public abstract List<Cliente> traeClientePorNombre(String filtro) throws Exception;
	public abstract List<Producto> traeProductoPorNombre(String nombre) throws Exception;
	public abstract List<Ubigeo> traeUbigeoPorNombre(String distrito) throws Exception;
	public abstract List<CaracteristicaProducto> listaCatacteristica() throws Exception;

}
