package com.senai.dsmovie.services;

import com.senai.dsmovie.dto.MovieDTO;
import com.senai.dsmovie.entities.Movie;
import com.senai.dsmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

  @Autowired
  private MovieRepository repository;

  @Transactional(readOnly = true)
  public Page<MovieDTO> FindAll(Pageable pageable) {
    Page<Movie> result = repository.findAll(pageable);

    Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
    return page;
  }

  @Transactional(readOnly = true)
  public MovieDTO FindById(Long id) {
    Movie result = repository.findById(id).get();
    MovieDTO movie = new MovieDTO(result);
    return movie;
  }
}
