package com.myboardplays.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myboardplays.entities.Partida;

public interface PartidaRepository extends JpaRepository <Partida,Integer>{
	@Query(value = "SELECT MAX(p.id) FROM Partida p")
    int obtenerUltimoIdLibre();
}
