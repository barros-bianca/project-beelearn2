package generation.org.blogPessoal.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import generation.org.blogPessoal.model.Grupo;

import generation.org.blogPessoal.repository.GrupoRepository;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/grupo")
public class GrupoController {
	
	@Autowired
	private GrupoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Grupo>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Grupo> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Grupo>> getByName(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Grupo> post (@RequestBody Grupo tema){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(tema));
	}

	@PutMapping
	public ResponseEntity<Grupo> put (@RequestBody Grupo tema){
		return ResponseEntity.ok(repository.save(tema));				
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
