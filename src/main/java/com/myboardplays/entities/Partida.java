package com.myboardplays.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;


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

	private Time duracion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String ubicacion;

	//bi-directional many-to-one association to Juego
	@ManyToOne
	@JoinColumn(name="id_juego")
	private Juego juego;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="creador")
	private Usuario usuario;

	public Partida() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getDuracion() {
		return this.duracion;
	}

	public void setDuracion(Time duracion) {
		this.duracion = duracion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Partida))
			return false;
		Partida other = (Partida) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Partida [id=" + id + ", duracion=" + duracion + ", fecha=" + fecha + ", ubicacion=" + ubicacion
				+ ", juego=" + juego + ", usuario=" + usuario + "]";
	}

	
}