package com.senai.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.dsmovie.entities.Score;
import com.senai.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
	
}
