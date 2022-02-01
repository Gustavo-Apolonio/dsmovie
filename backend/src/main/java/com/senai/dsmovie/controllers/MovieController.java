package com.senai.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.dsmovie.dto.MovieDTO;
import com.senai.dsmovie.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
	
	@Autowired	
	private MovieService service;
	
	@GetMapping
	public Page<MovieDTO> FindAll(Pageable pageable) {
		return service.FindAll(pageable);
	}
	
	@GetMapping(value = "/{id}")
	public MovieDTO FindById(@PathVariable Long id) {
		return service.FindById(id);
	}
	
}
