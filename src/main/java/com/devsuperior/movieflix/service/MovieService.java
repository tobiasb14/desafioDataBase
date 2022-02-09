package com.devsuperior.movieflix.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entity.Genre;
import com.devsuperior.movieflix.entity.Movie;
import com.devsuperior.movieflix.repository.GenreRepository;
import com.devsuperior.movieflix.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {

	private final MovieRepository movieRepository;
	private final GenreRepository genreRepository;

	public MovieDTO findById(Long id) {
		Movie movie = movieRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "produto não encontrado"));
		return new MovieDTO(movie);
	}

	public Page<MovieDTO> findMoviesWithGenre(Pageable pageable, Long genreId) {
		Genre genre = (genreId == null) ? null : genreRepository.getOne(genreId);
		return movieRepository.findMoviesWithGenre(pageable, genre).map(MovieDTO::new);
	}	
}
