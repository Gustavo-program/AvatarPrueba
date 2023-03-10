package com.avatar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.avatar.dto.Film;
import com.avatar.dto.People;
import com.avatar.dto.Swapi;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FilmsService {

//	@Value("${spring.external.service.base-url}")
//	private String baseUrl;

	private final RestTemplate restTemplate;

//	public Swapi<Film> getFilms(Swapi<Film> films){
//		Swapi<Film> response = restTemplate.getForObject("https://swapi.dev/api/films", films.getClass());
//		return response;
//	}

	public Swapi<Film> getFilms() {

		Swapi<Film> response = restTemplate.getForObject("https://swapi.dev/api/films", Swapi.class);

		return response;
		// ArrayList people = new ArrayList<>();
		// ArrayList<Film> film = new ArrayList<Film>();
		// film.add((Film) response.getResults());

//		for (int i = 0; i < film.size(); i++) {
//			System.out.println(film.get(i).getCharacters());
//		}
//		System.out.println(response);
//		Swapi<Film> listafilm = new ArrayList<>();
//		//Swapi<Film>[] arrayObjetos=new Swapi[0];
//		listafilm=response;
//		for(Film cadena:arrayObjetos) {
//		      System.out.println(cadena);
//		      }

		// System.out.println(response.getResults());

	}

	public String Ruta() {

		ArrayList<Film> peliculas = (ArrayList<Film>) getFilms().getResults();// obtengo toda la informacion de
																				// peliculas
		String ruta= "";
		
		for (int i = 0; i < peliculas.size(); i++) {
			

			for (int j = 0; j < peliculas.get(i).getCharacters().size(); j++) {
				
				List<String> urls = peliculas.get(j).getCharacters();
				
				for (int k = 0; k < urls.size(); k++) {
					ruta = urls.get(k);
					
				}
			}
		}
		return ruta;
	}

	public List<Film> getFilm(int id) {
		Film response = restTemplate.getForObject("https://swapi.dev/api/films/" + id, Film.class);
		return Arrays.asList(response);
	}

	public People getPeopleUrl() {

		People response = restTemplate.getForObject(Ruta(), People.class);
		System.out.println(response.getName());
		return response;
	}

	public Swapi<People> getPeoples() {

		Swapi<People> response = restTemplate.getForObject("https://swapi.dev/api/people", Swapi.class);
		return response;
	}

}
