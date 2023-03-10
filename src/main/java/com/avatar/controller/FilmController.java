package com.avatar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avatar.dto.Film;
import com.avatar.dto.People;
import com.avatar.dto.Swapi;
import com.avatar.service.FilmsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class FilmController {

	private final FilmsService service;

	@GetMapping("/films")
	public String ListaPeliculas(Model modelo) {

		System.out.println(service.getFilms().getResults());
		modelo.addAttribute("peliculas", service.getFilms());

		return "peliculas";
	}

	@GetMapping("/films/{id}")
	// @ResponseBody
	public List<Film> getFilms(@PathVariable Integer id) {
		return service.getFilm(id);
	}

	@GetMapping("/character")
	public String ListaPersona(Model modelo) {
		// service.getPeopleUrl();
		// modelo.addAttribute("actores",service.getPeopleUrl());
		return "actores";
	}

	@GetMapping("/rutas")
	public String ListaRuta() {
		service.Ruta();
		// modelo.addAttribute("actores",service.getPeopleUrl());
		return "actores";
	}

	@GetMapping("/peoples")
	public String ListaActores(Model modelo) {
		modelo.addAttribute("actores", service.getPeoples());

		return "actores";
	}


}
