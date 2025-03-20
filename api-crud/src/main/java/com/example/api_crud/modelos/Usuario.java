package com.example.api_crud.modelos;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long PK_ID_USUARIO;
	
	private String NOMBRE_APELLIDO;
	
	private String USERNAME;
	
	private String NACIMIENTO;
	
	private String PASSWORD;
	
	private String EMAIL;
	
	public Usuario() {
		
	}
	



	public long getPK_ID_USUARIO() {
		return PK_ID_USUARIO;
	}

	public void setPK_ID_USUARIO(long pK_ID_USUARIO) {
		PK_ID_USUARIO = pK_ID_USUARIO;
	}

	public String getNOMBRE_APELLIDO() {
		return NOMBRE_APELLIDO;
	}

	public void setNOMBRE_APELLIDO(String nOMBRE_APELLIDO) {
		NOMBRE_APELLIDO = nOMBRE_APELLIDO;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getNACIMIENTO() {
		return NACIMIENTO;
	}

	public void setNACIMIENTO(String nACIMIENTO) {
		NACIMIENTO = nACIMIENTO;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
}
