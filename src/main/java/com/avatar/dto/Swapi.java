package com.avatar.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Swapi<T> {
	
	private String count;
	private String next;
	private String previous;
	private List<T> results;
	

}
