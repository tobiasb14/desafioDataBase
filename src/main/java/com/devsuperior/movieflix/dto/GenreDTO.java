package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entity.Genre;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GenreDTO {

	private Long id;
	private String name;
	
	public GenreDTO(Genre genre) {
		this.id = genre.getId();
		this.name = genre.getName();
	}
}
