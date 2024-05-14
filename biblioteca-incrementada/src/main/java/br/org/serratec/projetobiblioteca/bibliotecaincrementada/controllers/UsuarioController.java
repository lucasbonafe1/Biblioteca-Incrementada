package br.org.serratec.projetobiblioteca.bibliotecaincrementada.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Usuario;
import br.org.serratec.projetobiblioteca.bibliotecaincrementada.services.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		return new ResponseEntity<>(usuarioService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id) { 
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Usuario>save(@RequestBody Usuario usuario){
		return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Usuario>update(@RequestBody Usuario usuario){
		return new ResponseEntity<>(usuarioService.save(usuario),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> delete(@PathVariable Integer id) {
		return new ResponseEntity<>(usuarioService.deleteById(id), HttpStatus.OK);
	}	
	
}