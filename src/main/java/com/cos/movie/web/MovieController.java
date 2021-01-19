package com.cos.movie.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.movie.domain.CommonDto;
import com.cos.movie.domain.Movie;
import com.cos.movie.domain.MovieRepository;
import com.cos.movie.domain.SaveReqDto;
import com.cos.movie.domain.UpdateReqDto;

@RestController
public class MovieController {
	
	private MovieRepository movieRepository;
	
	// DI(의존성 주입)
	public MovieController(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	// http://localhost:8080/movie
	@GetMapping("/movie")
	public CommonDto<List<Movie>> findAll() {
		System.out.println("findAll()");
		return new CommonDto<>(HttpStatus.OK.value(), movieRepository.findAll()) ;
	}
	
	// http://localhost:8080/movie/8
	@GetMapping("/movie/{id}")
	public CommonDto<Movie> findById(@PathVariable int id) {
		System.out.println("findById() : id : " + id );
		return new CommonDto<>(HttpStatus.OK.value(), movieRepository.findById(id));
	}
	
	// http://localhost:8080/movie
	@PostMapping("/movie")
	public CommonDto<String> save(@RequestBody SaveReqDto dto) throws Exception {
		System.out.println("save()");
		System.out.println("movie : " + dto);
		movieRepository.save(dto);
		return new CommonDto<>(HttpStatus.OK.value(),"ok");
	}
	
	// http://localhost:8080/movie/8
	@DeleteMapping("/movie/{id}")
	public CommonDto<String> delete(@PathVariable int id) {
		System.out.println("delete()");
		movieRepository.delete(id);
		return new CommonDto<>(HttpStatus.OK.value(),"ok");
	}
	
	// http://localhost:8080/movie/7
	@PutMapping("/movie/{id}")
	public CommonDto<String> update(@PathVariable int id, @RequestBody UpdateReqDto dto) throws Exception {
		System.out.println("update()");
		movieRepository.update(id, dto);
		return new CommonDto<>(HttpStatus.OK.value(),"ok");
	}
}
