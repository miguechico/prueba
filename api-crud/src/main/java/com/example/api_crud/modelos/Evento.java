package com.example.api_crud.modelos;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Evento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long PK_ID_EVENTO;
	
	private String NOMBRE;
	
	private String FECHA;
	
	private String TIPO;
	
	public Evento() {
		
	}

	public long getPK_ID_EVENTO() {
		return PK_ID_EVENTO;
	}

	public void setPK_ID_EVENTO(long pK_ID_EVENTO) {
		PK_ID_EVENTO = pK_ID_EVENTO;
	}

	public String getNOMBRE() {
		return NOMBRE;
	}

	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}

	public String getFECHA() {
		return FECHA;
	}

	public void setFECHA(String fECHA) {
		FECHA = fECHA;
	}

	public String getTIPO() {
		return TIPO;
	}

	public void setTIPO(String tIPO) {
		TIPO = tIPO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
