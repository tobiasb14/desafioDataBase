package com.devsuperior.movieflix.controller.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OauthCustomError {

	private String error;
	
	@JsonProperty("error_description")
    private String errorDescription;
}
