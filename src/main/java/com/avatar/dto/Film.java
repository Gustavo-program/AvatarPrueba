package com.avatar.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Film {
	
	private String title;
	
	private int episode_id;
	
	private String opening_crawl;
	
	private String director;
	
	private String producer;
	
	@JsonProperty("release_date")
	private Date release_date;
	
	@JsonProperty("species")
	private List<String> species;
	
	@JsonProperty("starships")
	private List<String> starships;
	
	@JsonProperty("vehicles")
	private List<String> vehicles;
	
	@JsonProperty("characters")
	private List<String> characters;
	
	@JsonProperty("planets")
	private List<String> planets;
	
	private String url;
	
	private String created;

	private String edited;
	
	private List<String> people;
	
	
	

	
	
}
