package com.myboardplays.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myboardplays.entities.Usuario;
import com.myboardplays.repository.UsuarioRepository;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	
	@Autowired
	private UsuarioRepository urepo;

	@Override
	public Usuario consultarUsuario(int idUsuario) {
		return urepo.findById(idUsuario).orElse(null);
	}

	@Override
	public boolean altaUsuario(Usuario usuario) {
		try {
			urepo.save(usuario);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean modificarUsuario(Usuario usuario) {
		try {
			urepo.save(usuario);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean eliminarUsuario(int idUsuario) {
		try {
			urepo.deleteById(idUsuario);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
