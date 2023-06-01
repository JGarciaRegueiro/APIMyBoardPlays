package com.myboardplays.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

	private int duracion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String ubicacion;

	//bi-directional many-to-one association to Juego
	@ManyToOne
	@JoinColumn(name="id_juego")
	private Juego juego;

	//bi-directional many-to-one association to Creador
	@ManyToOne
	@JoinColumn(name="creador")
	private Usuario creador;
	
	//bi-directional many-to-one association to Usuario
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
		@JoinTable(
				name="usuariospartidas",
				joinColumns={@JoinColumn(name="id_partida")},
				inverseJoinColumns={@JoinColumn(name="id_usuario")}
		)
	private List<Usuario> jugadores;

	public Partida() {
		this.jugadores = new ArrayList<>();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Usuario getCreador() {
		return this.creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
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
				+ ", juego=" + juego + ", usuario=" + creador + "]";
	}
	
	public List<Usuario> getJugadores() {
		return this.jugadores;
	}

	public void setPartidas(List<Usuario> jugadores) {
		this.jugadores = jugadores;
	}

	public Usuario addJugadores(Usuario jugadores ) {
		getJugadores().add(jugadores);

		return jugadores;
	}

	public Usuario removeUsuario(Usuario jugadores) {
		getJugadores().remove(jugadores);

		return jugadores;
	}

	
}