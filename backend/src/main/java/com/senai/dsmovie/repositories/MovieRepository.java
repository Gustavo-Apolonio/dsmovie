package com.senai.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
