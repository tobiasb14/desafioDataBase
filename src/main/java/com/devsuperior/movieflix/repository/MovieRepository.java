package com.devsuperior.movieflix.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entity.Genre;
import com.devsuperior.movieflix.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query("SELECT m FROM Movie m WHERE (:genre IS NULL OR m.genre = :genre) ORDER BY m.title")
	Page<Movie> findMoviesWithGenre(Pageable pageable, Genre genre);
}
