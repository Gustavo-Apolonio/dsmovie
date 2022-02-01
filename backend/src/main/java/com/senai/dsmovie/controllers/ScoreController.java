package com.senai.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.dsmovie.dto.MovieDTO;
import com.senai.dsmovie.dto.ScoreDTO;
import com.senai.dsmovie.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
	
	@Autowired
	private ScoreService service;
	
	@PutMapping
	public MovieDTO SaveScore(@RequestBody ScoreDTO dto) {
		MovieDTO movieDto = service.SaveScore(dto);
		return movieDto;
	}
	
}
