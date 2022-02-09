package com.devsuperior.movieflix.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.devsuperior.movieflix.entity.Review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

	private Long id;
	@NotBlank
	private String text;
	@NotNull
	private Long movieId;
	private UserDTO user;
	
	public ReviewDTO(Review review) {
		this.id = review.getId();
		this.text = review.getText();
		this.movieId = review.getMovie().getId();
		this.user = new UserDTO(review.getUser());
	}
}
