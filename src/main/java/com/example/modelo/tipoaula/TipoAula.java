package com.example.modelo.tipoaula;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CTRTipoAula")
public class TipoAula {

	@Id
	private String iditem;
	
	@Column
	private String txnombre;
	
	@Column
	private String txcodigo;
	
	@Column
	private String bcodigo;

	public TipoAula(String iditem, String txnombre, String txcodigo, String bcodigo) {
		this.iditem = iditem;
		this.txnombre = txnombre;
		this.txcodigo = txcodigo;
		this.bcodigo = bcodigo;
	}

	public String getIditem() {
		return iditem;
	}

	public void setIditem(String iditem) {
		this.iditem = iditem;
	}

	public String getTxnombre() {
		return txnombre;
	}

	public void setTxnombre(String txnombre) {
		this.txnombre = txnombre;
	}

	public String getTxcodigo() {
		return txcodigo;
	}

	public void setTxcodigo(String txcodigo) {
		this.txcodigo = txcodigo;
	}

	public String getBcodigo() {
		return bcodigo;
	}

	public void setBcodigo(String bcodigo) {
		this.bcodigo = bcodigo;
	}

	public TipoAula() {
	}
	
	
	
}


