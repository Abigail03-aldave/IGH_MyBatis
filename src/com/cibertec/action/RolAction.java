package com.cibertec.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.cibertec.bean.Rol;
import com.cibertec.dao.CapaDAORolImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@ParentPackage("dawi")
public class RolAction extends ActionSupport {

	private static final Log log = LogFactory.getLog(RolAction.class);

	@Getter
	@Setter
	private Rol r = new Rol();
	
	@Getter
	@Setter
	private String id;
	
	@Getter
	@Setter
	private String filtro;
	
	@Getter
	@Setter
	private List<Rol> lstRol= new ArrayList<Rol>();
	
	public Rol getR() {
		return r;
	}

	public void setR(Rol r) {
		this.r = r;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Rol> getLstRol() {
		return lstRol;
	}

	public void setLstRol(List<Rol> lstRol) {
		this.lstRol = lstRol;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	///******************************************LISTAR ROL
	private Map<String, Object> session = ActionContext.getContext().getSession();

	@Action(value="/consultaRol",results={@Result(name="success", location="/intranetCrudRol.jsp")})
	public String listar(){
		log.info("En listar Rol");	
		CapaDAORolImpl service = new CapaDAORolImpl();
		try {
			lstRol =  service.listaRol(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	///******************************************REGISTRAR ROL
	@Action(value = "/registraRol", results = {
			@Result(name = "success", location = "/intranetCrudRol.jsp", type = "redirect") })
	public String registra() {
		log.info("En registrar Caracteristica");
		try {
			CapaDAORolImpl service = new CapaDAORolImpl();
			int s = service.insertarRol(r);
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
	///******************************************ELIMINAR ROL
	@Action(value="/eliminaRol",results={@Result(name="success", location="/intranetCrudRol.jsp", type = "redirect")	})
	public String elimina(){
		log.info("En eliminar Caracteristica");
		try {
			CapaDAORolImpl service = new CapaDAORolImpl();
			int i=service.eliminarRol(Integer.parseInt(id));
			
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
	///******************************************ACTUALIZAR ROL
	@Action(value="/actualizaRol",results={@Result(name="success", location="/intranetCrudRol.jsp", type = "redirect")})
	public String actualiza(){
		log.info("En actualizar Cliente");	
		try {
			CapaDAORolImpl service = new CapaDAORolImpl();
			int i=service.actualizarRol(r);
			if (i > 0) {
				session.put("MENSAJE", "Actualizacion exitosa");
			} else {
				session.put("MENSAJE", "Actualizacion errónea");
			}
		} catch (Exception e) {e.printStackTrace();}
		return SUCCESS;
	}


}
