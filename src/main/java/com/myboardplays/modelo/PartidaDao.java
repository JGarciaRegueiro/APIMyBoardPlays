package com.myboardplays.modelo;

import java.util.List;

import com.myboardplays.entities.Juego;
import com.myboardplays.entities.Partida;

public interface PartidaDao {
	
	List<Juego> consultarTodos();
	Partida consultarPartida (int idPartida);
	boolean altaPartida (Partida partida);
	boolean modificarPartida (Partida partida);
	boolean eliminarPartida (int idPartida);
}
