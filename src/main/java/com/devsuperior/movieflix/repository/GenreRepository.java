package com.devsuperior.movieflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.movieflix.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
