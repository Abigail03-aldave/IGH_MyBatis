package com.cibertec.bean;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cliente {
	private int idcliente;
	private String correo;
	private String fecharegistro;
	private String login;
	private String password;
	private String direccion;
	private String estado;
	private Ubigeo ubigeo;
}
