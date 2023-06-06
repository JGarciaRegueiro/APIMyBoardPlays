package com.myboardplays.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the partidas database table.
 * 
 */
@Entity
@Table(name="partidas")
@NamedQuery(name="Partida.findAll", query="SELECT p FROM Partida p")
public class Partida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int creador;

	private int duracion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="id_ganador")
	private int idGanador;

	private String ubicacion;

	//uni-directional many-to-one association to Juego
	@ManyToOne
	@JoinColumn(name="id_juego")
	private Juego juego;

	public Partida() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCreador() {
		return this.creador;
	}

	public void setCreador(int creador) {
		this.creador = creador;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdGanador() {
		return this.idGanador;
	}

	public void setIdGanador(int idGanador) {
		this.idGanador = idGanador;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Juego getJuego() {
		return this.juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Partida))
			return false;
		Partida other = (Partida) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
	

}