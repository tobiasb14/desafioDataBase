package com.devsuperior.movieflix.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.service.MovieService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

	private final MovieService movieService;
	
	@GetMapping("/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(movieService.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<Page<MovieDTO>> findMoviesWithGenre(Pageable pageable, @RequestParam(required = false) Long genreId) {
		return ResponseEntity.ok(movieService.findMoviesWithGenre(pageable, genreId));
	}
}
