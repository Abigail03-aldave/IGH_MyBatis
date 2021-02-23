package com.cibertec.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.cibertec.bean.Cliente;
import com.cibertec.bean.Comprobante;
import com.cibertec.bean.ComprobanteDetalle;
import com.cibertec.bean.Pedido;
import com.cibertec.bean.Producto;
import com.cibertec.bean.Usuario;
import com.cibertec.dao.CapaDAOImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@ParentPackage("dawi")
public class ComprobanteAction extends ActionSupport {

	private static final Log log = LogFactory.getLog(ComprobanteAction.class);

	@Getter @Setter private Comprobante t = new Comprobante();
	
	private @Getter @Setter String filtro="";

	private @Getter @Setter List<Comprobante> lstComprobante= new ArrayList<Comprobante>();
	private @Getter @Setter List<Pedido> lstPedido= new ArrayList<Pedido>();
	private @Getter @Setter List<Producto> lstProducto= new ArrayList<Producto>();
	private @Getter	@Setter ArrayList<ComprobanteDetalle> lstSeleccion;
	private @Getter @Setter List<Usuario> lstUsuario= new ArrayList<Usuario>();
	private Map<String, Object> session = ActionContext.getContext().getSession();
	CapaDAOImpl service = new CapaDAOImpl();
	
	//ConsultaComprobante
	@Getter	@Setter private String estado;
	@Getter	@Setter private String idUsuario;
	
	
	@Getter	@Setter private int idproducto;
	@Getter	@Setter private String nombreProducto;
	@Getter	@Setter private double precio;
	@Getter	@Setter private int cantidad;
	@Getter	@Setter private String mensaje;
	@Getter @Setter private int idpedido;
	@Getter	@Setter Pedido p;
	@Getter	@Setter Usuario u;
	@Getter	@Setter Cliente cl;
	
	@Action(value = "/cargaPedido",results={@Result(name="success",type ="json")})
	public String cargaPedido() {
		try {lstPedido=service.listaPedidoPor(filtro);}catch (Exception e) {e.printStackTrace();}
		return SUCCESS;
	}
	@Action(value="/cargaProducto",results={@Result(name="success", type = "json")})
	public String cargaProducto(){
		try {lstProducto=service.listaProductoPor(filtro);}catch (Exception e) {e.printStackTrace();}
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	@Action(value = "/agregarSeleccionProducto", results = { @Result(name = "success", type = "json") })
	public String agregaproducto() {
		try {
				lstSeleccion = (ArrayList<ComprobanteDetalle>) session.get("data");
				if (lstSeleccion == null) {lstSeleccion = new ArrayList<ComprobanteDetalle>();}
				ComprobanteDetalle obj = new ComprobanteDetalle();
				obj.setIdproducto(idproducto);
				obj.setNombre(nombreProducto);
				obj.setCantidad(cantidad);
				obj.setPrecio(precio);

				lstSeleccion.add(obj);
				session.put("data", lstSeleccion);
		} catch (Exception e) {e.printStackTrace();}
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	@Action(value = "/eliminaSeleccion", results = { @Result(name = "success", type = "json") })
	public String elimina() {
		try {
			lstSeleccion = (ArrayList<ComprobanteDetalle>) session.get("data");
			if (lstSeleccion != null) {
				for (ComprobanteDetalle x : lstSeleccion) {
					if (x.getIdproducto()==idproducto){lstSeleccion.remove(x);break;}
				}
				session.put("data", lstSeleccion);
				lstSeleccion = (ArrayList<ComprobanteDetalle>) session.get("data");
			}
		} catch (Exception e) {e.printStackTrace();}
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	@Action(value = "/registra", results = { @Result(name = "success", type="json") })       
	public String registra() {
		try {System.out.println(idpedido);
			Comprobante c= new Comprobante();
			u=new Usuario();u.setIdUsuario("1");
			p=new Pedido();p.setIdpedido(idpedido);
			cl=new Cliente();cl.setIdcliente(1);
			c.setPedido(p);
			c.setUsuario(u);
			c.setCliente(cl);

			ArrayList<ComprobanteDetalle> data = (ArrayList<ComprobanteDetalle>)session.get("data");
			c.setDetalle(data);

			int s = service.insertarComprobante(c);
			session.clear();
			
			if ( s > 0 ) {
				mensaje =  "Se generó Comprobante con código N°" +c.getIdcomprobante()+"<br><br>";
				mensaje += "Pedido :"+c.getPedido().getIdpedido()+ "<br><br>";
				mensaje += "<table class=\"table\"><tr><td>Producto</td><td>Precio</td><td>Cantidad</td><td>Subtotal</td></tr>";
				double monto = 0;
				for (ComprobanteDetalle x : data) {
					mensaje +="<tr><td>"+ x.getNombre() + "</td><td>" + x.getPrecio()+ "</td><td>" + x.getCantidad() +"</td><td>" + x.getTotal() +"</td></tr>";
					monto += x.getCantidad() * x.getPrecio();
				}
				mensaje += "</table><br>";
				mensaje += "Monto a pagar : "+monto;
			}	
		} catch (Exception e) {e.printStackTrace();}
		return SUCCESS;
	}
	
// Consulta Comprobante 
				@SuppressWarnings("unchecked")
				@Action(value = "/listaComprobante", results = { @Result(name = "success", type="json") })       
				public String listarComprobante() {
			    log.info("En listar comprobante");
					try {
			             Comprobante c= new Comprobante();
			             u=new Usuario();u.setIdUsuario(idUsuario);
			 			 c.setEstado(estado);
			 			 c.setUsuario(u);
			             lstComprobante = service.listaComprobantePorFiltro(c);
			        } catch (Exception e) {e.printStackTrace();}
					return SUCCESS;
			    }
				@Action(value = "/cargaUsuario",results={@Result(name="success",type ="json")})
				public String cargaUsuario() {
					try {lstUsuario=service.listaUsuario();}catch (Exception e) {e.printStackTrace();}
					return SUCCESS;
				}
 }
