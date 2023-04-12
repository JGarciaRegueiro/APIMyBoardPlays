package com.myboardplays.modelo;

import com.myboardplays.entities.Usuario;

public interface UsuarioDao {
	
	Usuario consultarUsuario (int idUsuario);
	boolean altaUsuario (Usuario usuario);
	boolean modificarUsuario (Usuario usuario);
	boolean eliminarUsuario (int idUsuario);

}
