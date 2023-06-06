package com.myboardplays.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	private String nombre;

	private String pass;

	//uni-directional many-to-many association to Partida
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
		name="usuariospartidas"
		, joinColumns={
			@JoinColumn(name="id_usuario", referencedColumnName="id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_partida")
			}
		)
	private List<Partida> partidas;

	//uni-directional many-to-many association to Juego
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
		name="usuariosjuegos"
		, joinColumns={
			@JoinColumn(name="id_usuario", referencedColumnName="id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_juego")
			}
		)
	private List<Juego> juegos;

	public Usuario() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<Partida> getPartidas() {
		return this.partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	public List<Juego> getJuegos() {
		return this.juegos;
	}

	public void setJuegos(List<Juego> juegos) {
		this.juegos = juegos;
	}

	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void addJuego(Juego juego) {
		if (juegos ==null)
			juegos = new ArrayList<>();
		juegos.add(juego);
	}
	
	public void removeJuego(Juego juego) {
		if (juegos ==null)
			juegos = new ArrayList<>();
		juegos.remove(juego);
	}
	
	public void addPartida(Partida partida) {
		if (partidas ==null)
			partidas = new ArrayList<>();
		partidas.add(partida);
	}
	
	public void removePartida(Partida partida) {
		if (partidas ==null)
			partidas = new ArrayList<>();
		partidas.remove(partida);
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
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	

}