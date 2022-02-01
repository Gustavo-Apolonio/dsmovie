package com.senai.dsmovie.repositories;

import com.senai.dsmovie.entities.Score;
import com.senai.dsmovie.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {}
