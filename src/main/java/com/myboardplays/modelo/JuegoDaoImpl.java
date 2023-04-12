package com.myboardplays.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myboardplays.entities.Juego;
import com.myboardplays.repository.JuegoRepository;

@Repository
public class JuegoDaoImpl implements JuegoDao {
	
	@Autowired
	private JuegoRepository jrepo;
	
	@Override
	public Juego consultarJuego(int idJuego) {
		return jrepo.findById(idJuego).orElse(null);
	}
	
	@Override
	public boolean altaJuego(Juego juego) {
		try {
			jrepo.save(juego);
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean modificarJuego(Juego juego) {
		try {
			jrepo.save(juego);
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean eliminarJuego(int idJuego) {
		try {
			jrepo.deleteById(idJuego);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
