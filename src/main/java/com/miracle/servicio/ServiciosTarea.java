package com.miracle.servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.miracle.modelo.Embedding;
import com.miracle.repo.IRepository;

@RestController
@RequestMapping("/listadoEmbeddings")
public class ServiciosTarea {

	@Autowired
	IRepository repo;

	@GetMapping("/lista")
	public List<Embedding> listar() {
		return repo.findAll();

	}

	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {

		repo.deleteById(id);
	}

	@PostMapping("/insercion2")
    public ResponseEntity<Map<String, Object>> insertar2(@RequestBody Embedding emb) {
        Map<String, Object> response = new HashMap<>();
        try {
            Embedding savedEmb = repo.save(emb);
            response.put("status", "OK");
            response.put("message", "Identificador guardado: " + savedEmb.getId());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("status", "ERROR");
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@PostMapping("/insercion")
	public void insertar(@RequestBody Embedding emb) {
		
		repo.save(emb);
		
		
	}

	@PutMapping("/modificarEmbedding")
	public void modificar(@RequestBody Embedding emb) {

		repo.save(emb);

	}

}