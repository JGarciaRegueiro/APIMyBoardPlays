package com.myboardplays.modelo;

import com.myboardplays.entities.Juego;

public interface JuegoDao {
	
	Juego consultarJuego (int idJuego);
	boolean altaJuego (Juego juego);
	boolean modificarJuego (Juego juego);
	boolean eliminarJuego (int idJuego);
	
}
