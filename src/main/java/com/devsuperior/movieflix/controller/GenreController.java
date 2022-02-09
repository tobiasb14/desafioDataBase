package com.devsuperior.movieflix.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.service.GenreService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController {

	private final GenreService genreService;
	
	@GetMapping
	public ResponseEntity<List<GenreDTO>> findAllGenres() {
		return ResponseEntity.ok(genreService.findAllGenres());
	}
}
