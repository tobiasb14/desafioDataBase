package com.devsuperior.movieflix.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entity.Review;
import com.devsuperior.movieflix.repository.MovieRepository;
import com.devsuperior.movieflix.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {
	
	private final ReviewRepository reviewRepository;
	private final MovieRepository movieRepository;
	private final AuthService authService;
	
	@Transactional
	public ReviewDTO insert(ReviewDTO dto) {
		authService.validateMember();
		return new ReviewDTO(reviewRepository.save(convertDtoToEntity(dto, new Review())));
	}

	private Review convertDtoToEntity(ReviewDTO dto, Review review) {
		review.setText(dto.getText());
		review.setMovie(movieRepository.getOne(dto.getMovieId()));
		review.setUser(authService.authenticated());
		return review;
	}
}
