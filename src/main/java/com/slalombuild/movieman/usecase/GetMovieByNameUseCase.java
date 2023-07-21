/* (C) 2023 */
package com.slalombuild.movieman.usecase;

import com.slalombuild.movieman.domain.repository.MovieRepository;
import com.slalombuild.movieman.usecase.model.GetMoviesResult;
import com.slalombuild.movieman.usecase.model.MovieMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetMovieByNameUseCase {
  @NonNull private MovieRepository movieRepository;

  public GetMoviesResult findByName(String name) {
    var movies = movieRepository.findFirst1ByNameStartingWith(name);

    var viewModels = movies.stream().map(MovieMapper.INSTANCE::toMovieModel).toList();

    return new GetMoviesResult(viewModels); // TODO what if this is null?
  }
}
