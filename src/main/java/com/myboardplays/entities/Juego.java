package com.myboardplays.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the juegos database table.
 * 
 */
@Entity
@Table(name="juegos")
@NamedQuery(name="Juego.findAll", query="SELECT j FROM Juego j")
public class Juego implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	private String dificultad;

	@Column(name="max_participantes")
	private int maxParticipantes;

	@Column(name="min_participantes")
	private int minParticipantes;

	private String nombre;

	//bi-directional many-to-one association to Partida
	@OneToMany(mappedBy="juego")
	private List<Partida> partidas;

	public Juego() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDificultad() {
		return this.dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	public int getMaxParticipantes() {
		return this.maxParticipantes;
	}

	public void setMaxParticipantes(int maxParticipantes) {
		this.maxParticipantes = maxParticipantes;
	}

	public int getMinParticipantes() {
		return this.minParticipantes;
	}

	public void setMinParticipantes(int minParticipantes) {
		this.minParticipantes = minParticipantes;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Partida> getPartidas() {
		return this.partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	public Partida addPartida(Partida partida) {
		getPartidas().add(partida);
		partida.setJuego(this);

		return partida;
	}

	public Partida removePartida(Partida partida) {
		getPartidas().remove(partida);
		partida.setJuego(null);

		return partida;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Juego))
			return false;
		Juego other = (Juego) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Juego [id=" + id + ", descripcion=" + descripcion + ", dificultad=" + dificultad + ", maxParticipantes="
				+ maxParticipantes + ", minParticipantes=" + minParticipantes + ", nombre=" + nombre + ", partidas="
				+ partidas + "]";
	}
	
	
	

}