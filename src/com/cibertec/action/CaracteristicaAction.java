package com.cibertec.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.cibertec.bean.CaracteristicaCliente;
import com.cibertec.dao.CapaDAOCaracteristicaImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@ParentPackage("dawi")
public class CaracteristicaAction extends ActionSupport {

	private static final Log log = LogFactory.getLog(CaracteristicaAction.class);

	@Getter
	@Setter
	private CaracteristicaCliente c = new CaracteristicaCliente();
	
	@Getter
	@Setter
	private String id;
	
	@Getter
	@Setter
	private String filtro;
	
	@Getter
	@Setter
	private List<CaracteristicaCliente> lstCaracteristica= new ArrayList<CaracteristicaCliente>();
	
	///******************************************LISTAR CARACTERISTICA
	private Map<String, Object> session = ActionContext.getContext().getSession();

	@Action(value="/consultaCaracteristica",results={@Result(name="success", location="/intranetCrudCaracteristica.jsp")})
	public String listar(){
		log.info("En listar Cliente");	
		CapaDAOCaracteristicaImpl service = new CapaDAOCaracteristicaImpl();
		try {
			lstCaracteristica =  service.listaCaracteristica(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	///******************************************REGISTRAR CARACTERISTICA
	@Action(value = "/registraCaracteristica", results = {
			@Result(name = "success", location = "/intranetCrudCaracteristica.jsp", type = "redirect") })
	public String registra() {
		log.info("En registrar Caracteristica");
		try {
			CapaDAOCaracteristicaImpl service = new CapaDAOCaracteristicaImpl();
			int s = service.insertarCaracteristica(c);
			if (s > 0) {
				session.put("MENSAJE", "Registro exitoso");
			} else {
				session.put("MENSAJE", "Registro erróneo");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	///******************************************ELIMINAR CARACTERISTICA
	@Action(value="/eliminaCaracteristica",results={@Result(name="success", location="/intranetCrudCaracteristica.jsp", type = "redirect")	})
	public String elimina(){
		log.info("En eliminar Caracteristica");
		try {
			CapaDAOCaracteristicaImpl service = new CapaDAOCaracteristicaImpl();
			int i=service.eliminarCaracteristica(Integer.parseInt(id));
			
			if (i > 0) {
				session.put("MENSAJE", "Eliminacion exitosa");
			} else {
				session.put("MENSAJE", "Eliminacion errónea");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	///******************************************ACTUALIZAR CARACTERISTICA
	@Action(value="/actualizaCaracteristica",results={@Result(name="success", location="/intranetCrudCaracteristica.jsp", type = "redirect")})
	public String actualiza(){
		log.info("En actualizar Cliente");	
		try {
			CapaDAOCaracteristicaImpl service = new CapaDAOCaracteristicaImpl();
			int i=service.actualizarCaracteristica(c);
			if (i > 0) {
				session.put("MENSAJE", "Actualizacion exitosa");
			} else {
				session.put("MENSAJE", "Actualizacion errónea");
			}
		} catch (Exception e) {e.printStackTrace();}
		return SUCCESS;
	}


}
