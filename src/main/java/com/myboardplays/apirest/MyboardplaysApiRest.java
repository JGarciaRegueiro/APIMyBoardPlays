package com.myboardplays.apirest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.myboardplays.entities.Juego;
import com.myboardplays.entities.Partida;
import com.myboardplays.entities.Usuario;
import com.myboardplays.modelo.JuegoDao;
import com.myboardplays.modelo.PartidaDao;
import com.myboardplays.modelo.UsuarioDao;

@RestController
@RequestMapping("/apirest")
public class MyboardplaysApiRest {
	
	/**
	 * RestController para CRUD Usuario
	 */
	@Autowired
	private UsuarioDao udao;
	
	@GetMapping ("/usuarios")
	public List<Usuario> consultarUsuarios(){
		return udao.consultarTodos();
	}
	
	@GetMapping ("/usuario/consultar/{id}")
	public Usuario consultarUsuario (@PathVariable ("id") int idUsuario) {
		return udao.consultarUsuario(idUsuario);
	}

	@PostMapping ("/usuario/alta")
	public Usuario altaUsuario (@RequestBody Usuario usuario) {
		usuario.setPass(new BCryptPasswordEncoder().encode(usuario.getPass()));
		usuario.setFechaAlta(new Date());
		udao.altaUsuario(usuario);
		return usuario;
	}
	
	@PostMapping ("/usuario/modificar")
	public Usuario modificarUsuario (Usuario usuario) {
		udao.modificarUsuario(usuario);
		return usuario;
	}
	
	@DeleteMapping ("usuario/eliminar/{id}")
	public String modificarUsuario (@PathVariable int idUsuario) {
		udao.eliminarUsuario(idUsuario);
		return "Usuario eliminado";
	}
	
	/**
	 * RestController para CRUD Juego
	 */
	@Autowired
	private JuegoDao jdao;
	
	@GetMapping ("/juegos")
	public List<Juego> consultarJuegos(){
		return jdao.consultarTodos();
	}
	
	@GetMapping ("/juego/consultar/{id}")
	public Juego consultarJuego (@PathVariable int idJuego) {
		return jdao.consultarJuego(idJuego);
	}

	@PostMapping ("/juego/alta")
	public Juego altaJuego (Juego juego) {
		jdao.altaJuego(juego);
		return juego;
	}
	
	@PostMapping ("/juego/modificar")
	public Juego modificarJuego (Juego juego) {
		jdao.modificarJuego(juego);
		return juego;
	}
	
	@DeleteMapping ("juego/eliminar/{id}")
	public String modificarJuego (@PathVariable int idJuego) {
		jdao.eliminarJuego(idJuego);
		return "Juego eliminado";
	}
	
	/**
	 * RestController para CRUD Partida
	 */
	@Autowired
	private PartidaDao pdao;
	
	@GetMapping ("/partidas")
	public List<Juego> consultarPartidas(){
		return pdao.consultarTodos();
	}
	
	@GetMapping ("/partida/consultar/{id}")
	public Partida consultarPartida (@PathVariable int idPartida) {
		return pdao.consultarPartida(idPartida);
	}

	@PostMapping ("/partida/alta")
	public Partida altaPartida (Partida partida) {
		pdao.altaPartida(partida);
		return partida;
	}
	
	@PostMapping ("/partida/modificar")
	public Partida modificarPartida (Partida partida) {
		pdao.modificarPartida(partida);
		return partida;
	}
	
	@DeleteMapping ("partida/eliminar/{id}")
	public String modificarPartida (@PathVariable int idPartida) {
		pdao.eliminarPartida(idPartida);
		return "Partida eliminada";
	}
	
	
}
