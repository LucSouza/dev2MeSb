package br.com.dev2me.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev2me.entity.Movie;
import br.com.dev2me.repository.MovieRepository;

@RestController
@RequestMapping("/api/v1")
public class MovieController {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@GetMapping("/movies")
	public List<Movie> getAll(){
		return movieRepository.findAll();
	}
	@GetMapping("/movies/{id}")
	public ResponseEntity<Movie> getById(@PathVariable(value = "id")Long movieId){
		return movieRepository.findById(movieId)movieId;
	}
	
	@PostMapping("/movies")
	public Movie create(@RequestBody Movie movie) {
		return movieRepository.save(movie);
	}
	
	@PutMapping("/movies/{id}")
	public ResponseEntity<Movie> update(@PathVariable(value = "id") Long movieId, @RequestBody Movie movieDetails){
		return movieRepository.save(movieDetails);
	}
	
	@DeleteMapping("/movies/{id}")
	public void deleteUser(@PathVariable(value = "id")Long MovieId) throws Exception{
		movieRepository.delete(movieId)
	} 
	

}
