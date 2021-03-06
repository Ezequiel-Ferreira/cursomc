package com.example.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cursomc.domain.Categoria;
import com.example.cursomc.service.CategoriaService;

@RestController
@RequestMapping("categoria")
public class CategoriaResources {
	@Autowired
	private CategoriaService cateService;
	
	@PostMapping("/create")
	ResponseEntity<?> create(@RequestBody Categoria categoria){
		cateService.criarCategoria(categoria);
		return new ResponseEntity<>("Criado com sucesso", HttpStatus.OK);
	}
	
	@GetMapping("/categorias")
	ResponseEntity<List<Categoria>> listarCategorias() {
		List<Categoria> lista = new ArrayList<Categoria>();
		lista = cateService.buacarTodos();
	
		return new ResponseEntity<List<Categoria>>(lista, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Integer id){
		Categoria categoria = cateService.categoriaPorId(id);
		return new ResponseEntity<>(categoria, HttpStatus.OK);
	}
	
}
