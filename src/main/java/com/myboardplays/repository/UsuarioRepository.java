package com.myboardplays.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myboardplays.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
