package com.myboardplays.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myboardplays.entities.Juego;

public interface JuegoRepository extends JpaRepository <Juego,Integer> {

}
