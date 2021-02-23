package com.cibertec.bean;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comprobante {
	private int idcomprobante;
	private Date fechaRegistro;
	private Date fechaPago;
	private String estado;
	private Pedido pedido;
	private Cliente cliente;
	private Usuario usuario;
	private List<ComprobanteDetalle> detalle;	
}
