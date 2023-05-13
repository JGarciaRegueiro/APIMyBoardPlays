package com.myboardplays.modelo;

import java.util.List;

import com.myboardplays.entities.Usuario;

public interface UsuarioDao {
	
	List<Usuario> consultarTodos();
	Usuario consultarUsuario (int idUsuario);
	boolean altaUsuario (Usuario usuario);
	boolean modificarUsuario (Usuario usuario);
	boolean eliminarUsuario (int idUsuario);
	
}
