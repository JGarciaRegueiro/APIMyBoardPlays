package com.myboardplays.modelo;

import java.util.List;
import java.util.Optional;

import com.myboardplays.entities.Usuario;

public interface UsuarioDao {
	
	List<Usuario> consultarTodos();
	Usuario consultarUsuario (int idUsuario);
	boolean altaUsuario (Usuario usuario);
	boolean modificarUsuario (Usuario usuario);
	boolean eliminarUsuario (int idUsuario);
	Optional<Usuario> consultarUsuarioByEmail(String email);
	
}
