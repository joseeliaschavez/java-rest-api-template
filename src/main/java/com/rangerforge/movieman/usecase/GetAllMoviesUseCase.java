/* (C) 2023 */
package com.rangerforge.movieman.usecase;

import com.rangerforge.movieman.domain.repository.MovieRepository;
import com.rangerforge.movieman.usecase.model.GetMoviesResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllMoviesUseCase {
  private final MovieMapper movieMapper;
  private final MovieRepository movieRepository;

  public GetMoviesResult getAllMovies() {
    var allMovies = movieRepository.findAll();

    var viewModels = allMovies.stream().map(movieMapper::toMovieModel).toList();

    return new GetMoviesResult(viewModels);
  }
}
