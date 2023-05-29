package com.myboardplays.modelo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myboardplays.entities.Partida;
import com.myboardplays.repository.PartidaRepository;

@Repository
public class PartidaDaoImpl implements PartidaDao {
	
	@Autowired 
	private PartidaRepository prepo;
	
	@Override
	public List<Partida> consultarTodos() {
		// TODO Auto-generated method stub
		return prepo.findAll();
	}

	@Override
	public Partida consultarPartida(int idPartida) {
		return prepo.findById(idPartida).orElse(null);
	}

	@Override
	public boolean altaPartida(Partida partida) {
		try {
			prepo.save(partida);
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean modificarPartida(Partida partida) {
		try {
			prepo.save(partida);
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean eliminarPartida(int idPartida) {
		try {
			prepo.deleteById(idPartida);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	@Override
	public int obtenerUltimoIdLibre() {
		return prepo.obtenerUltimoIdLibre();
	}
	

}
