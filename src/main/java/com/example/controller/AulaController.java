package com.example.controller;


import java.util.List;
import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.modelo.aula.Aula;
import com.example.services.AulaService;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@RestController
public class AulaController {

	@Autowired
	private AulaService cs;
	

	@GetMapping("/lienzos")
	public ResponseEntity<?> allProducts() {
		List<Aula> lienzos = cs.findAll();	
		
		return ResponseEntity.status(HttpStatus.OK).body(lienzos);
	}
	
//	
	@GetMapping("/lienzos/{id}")
	public ResponseEntity<?> getLienzo(@PathVariable String id) {
		Optional<Aula> productoOptional = cs.findById(id);
		if(productoOptional.isPresent()) {
			Aula canvas = productoOptional.get();
			return ResponseEntity.status(HttpStatus.OK).body(canvas);
		}else {
			throw new LienzoNoEncontradoException(id);
		}
	}
//
//	@GetMapping("/producto")
//	public ResponseEntity<?> getProducto2(@RequestParam String id) {
//		Canvas c =  ps.findById(id).get();
//		return ResponseEntity.status(HttpStatus.OK).body(c);
//
//	}
//
	@PostMapping("lienzo")
	public ResponseEntity<?> postCanvas(@RequestBody Aula nuevoCanvas) {
		Aula c =  nuevoCanvas;
		cs.save(c);
		return ResponseEntity.status(HttpStatus.CREATED).body(c);
		
	}

	@PutMapping("/lienzo/{id}")
	public ResponseEntity<?>  putLienzo(@RequestBody Aula editadoCanvas, @PathVariable String id) {
		editadoCanvas.setId(id);
		cs.edit(editadoCanvas).toString();
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	
	@DeleteMapping("/lienzo/{id}")
	public ResponseEntity<?>  deleteCanvas(@PathVariable String id) {
		cs.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}	
