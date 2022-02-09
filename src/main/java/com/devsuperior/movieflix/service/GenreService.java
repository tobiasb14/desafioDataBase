package com.devsuperior.movieflix.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.repository.GenreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GenreService {

	private final GenreRepository genreRepository;
	
	public List<GenreDTO> findAllGenres() {
		return genreRepository.findAll().stream().map(GenreDTO::new).collect(Collectors.toList());
	}
}
