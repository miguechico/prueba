package com.example.api_crud.modelos;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Caballo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long PK_ID_CABALLO;
	
	private String NOMBRE;
	
	private String RAZA;
	
	private String RENDIMIENTO;
	
	private long FK_ID_USUARIO;
	
	public Caballo() {
		
	}

	public long getPK_ID_CABALLO() {
		return PK_ID_CABALLO;
	}

	public void setPK_ID_CABALLO(long pK_ID_CABALLO) {
		PK_ID_CABALLO = pK_ID_CABALLO;
	}

	public String getNOMBRE() {
		return NOMBRE;
	}

	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}

	public String getRAZA() {
		return RAZA;
	}

	public void setRAZA(String rAZA) {
		RAZA = rAZA;
	}

	public String getRENDIMIENTO() {
		return RENDIMIENTO;
	}

	public void setRENDIMIENTO(String rENDIMIENTO) {
		RENDIMIENTO = rENDIMIENTO;
	}

	public long getFK_ID_USUARIO() {
		return FK_ID_USUARIO;
	}

	public void setFK_ID_USUARIO(long fK_ID_USUARIO) {
		FK_ID_USUARIO = fK_ID_USUARIO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
