package com.senai.dsmovie.services;

import com.senai.dsmovie.dto.MovieDTO;
import com.senai.dsmovie.dto.ScoreDTO;
import com.senai.dsmovie.entities.Movie;
import com.senai.dsmovie.entities.Score;
import com.senai.dsmovie.entities.User;
import com.senai.dsmovie.repositories.MovieRepository;
import com.senai.dsmovie.repositories.ScoreRepository;
import com.senai.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

  @Autowired
  private MovieRepository mvRepository;

  @Autowired
  private UserRepository usrRepository;

  @Autowired
  private ScoreRepository scrRepository;

  @Transactional
  public MovieDTO SaveScore(ScoreDTO dto) {
    User user = usrRepository.findByEmail(dto.getEmail());

    if (user == null) {
      user = new User();
      user.setEmail(dto.getEmail());
      user = usrRepository.saveAndFlush(user);
    }

    Movie movie = mvRepository.findById(dto.getMovieId()).get();

    Score score = new Score();
    score.setMovie(movie);
    score.setUser(user);
    score.setValue(dto.getScore());
    score = scrRepository.saveAndFlush(score);

    double sum = 0.0;
    for (Score s : movie.getScores()) {
      sum = sum + s.getValue();
    }

    double avg = sum / movie.getScores().size();

    movie.setScore(avg);
    movie.setCount(movie.getScores().size());

    movie = mvRepository.save(movie);

    return new MovieDTO(movie);
  }
}
