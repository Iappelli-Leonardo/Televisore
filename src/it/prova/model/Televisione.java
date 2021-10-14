package it.prova.model;

import java.util.Date;

public class Televisione {

	private Long id;
	private String marca;
	private String modello;
	private Date dataProduzione;

	public Televisione() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Televisione(String marca) {
		super();
		this.marca = marca;
	}

	public Televisione(String marca, String modello) {
		super();
		this.marca = marca;
		this.modello = modello;
	}

	public Televisione(String marca, String modello, Date dataProduzione) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.dataProduzione = dataProduzione;
	}

	public Televisione(Long id, String marca, String modello, Date dataProduzione) {
		super();
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.dataProduzione = dataProduzione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public Date getDataProduzione() {
		return dataProduzione;
	}

	public void setDataProduzione(Date dataProduzione) {
		this.dataProduzione = dataProduzione;
	}

	@Override
	public String toString() {
		return "Televisione [id=" + id + ", marca=" + marca + ", modello=" + modello + ", dataProduzione="
				+ dataProduzione + "]";
	}

}
