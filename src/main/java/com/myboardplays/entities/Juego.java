package com.myboardplays.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;


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
		if (!(obj instanceof Juego))
			return false;
		Juego other = (Juego) obj;
		if (id != other.id)
			return false;
		return true;
	}


	
	

}