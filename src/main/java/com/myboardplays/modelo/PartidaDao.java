package com.myboardplays.modelo;

import com.myboardplays.entities.Partida;

public interface PartidaDao {

	Partida consultarPartida (int idPartida);
	boolean altaPartida (Partida partida);
	boolean modificarPartida (Partida partida);
	boolean eliminarPartida (int idPartida);
	
}
