package com.myboardplays.modelo;

import java.util.List;

import com.myboardplays.entities.Partida;

public interface PartidaDao {
	
	List<Partida> consultarTodos();
	Partida consultarPartida (int idPartida);
	boolean altaPartida (Partida partida);
	boolean modificarPartida (Partida partida);
	boolean eliminarPartida (int idPartida);
	int obtenerUltimoIdLibre();
}
