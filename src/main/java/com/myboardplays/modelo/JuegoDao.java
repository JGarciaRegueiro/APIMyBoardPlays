package com.myboardplays.modelo;

import java.util.List;

import com.myboardplays.entities.Juego;

public interface JuegoDao {
	
	List<Juego> consultarTodos();
	Juego consultarJuego (int idJuego);
	boolean altaJuego (Juego juego);
	boolean modificarJuego (Juego juego);
	boolean eliminarJuego (int idJuego);
}
