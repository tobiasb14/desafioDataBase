package com.devsuperior.movieflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.movieflix.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
