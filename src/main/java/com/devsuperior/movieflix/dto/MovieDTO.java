package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entity.Movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

	private Long id;
	private String title;
	private String subTitle;
	private String synopsis;
	private Integer year;
	private String imgUrl;
	private GenreDTO genre;
	
	public MovieDTO(Movie movie) {
		this.id = movie.getId();
		this.title = movie.getTitle(); 
		this.subTitle = movie.getSubTitle();
		this.synopsis = movie.getSynopsis();
		this.year = movie.getYear();
		this.imgUrl = movie.getImgUrl();
		this.genre = new GenreDTO(movie.getGenre());
	}
}
