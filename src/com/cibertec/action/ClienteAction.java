package com.cibertec.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.cibertec.bean.Cliente;
import com.cibertec.dao.CapaDAOCliente;
import com.cibertec.dao.CapaDAOClienteImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@ParentPackage("dawi")

//@CommonsLog
public class ClienteAction extends ActionSupport {
	
	// GETTER AND SETTER para la consulta
	private @Getter @Setter List<Cliente> lstCliente = new ArrayList<Cliente>();
	private @Getter @Setter Cliente filtro;

	// GETTER AND SETTER Para insertar
	private @Getter @Setter Cliente cliente = new Cliente();

	private Map<String, Object> session = ActionContext.getContext().getSession();

	private CapaDAOCliente service = new CapaDAOClienteImpl();

	@Action(value = "/insertaCliente", results = {
			@Result(name = "success", location = "/intranetRegistroCliente.jsp", type = "redirect") })
	public String registra() {
		LOG.info("En registrar Cliente");
		try {
			CapaDAOClienteImpl service1 = new CapaDAOClienteImpl();
			int s = service1.insertaCliente(cliente);
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

	@Action(value = "/consultaCliente", results = { @Result(name = "success", type = "json") })
	public String listar() {
		LOG.info("En listar Cliente");
		try {
			
			lstCliente = service.listaCliente(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	      }
	
	}

	
	
	
	
