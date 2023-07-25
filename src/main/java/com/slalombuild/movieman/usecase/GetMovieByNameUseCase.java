/* (C) 2023 */
package com.slalombuild.movieman.usecase;

import com.slalombuild.movieman.domain.repository.MovieRepository;
import com.slalombuild.movieman.tmdb.TmdbMovieRepository;
import com.slalombuild.movieman.usecase.model.GetMoviesResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class GetMovieByNameUseCase {
  private final MovieMapper movieMapper;
  private final MovieRepository movieRepository;
  private final TmdbMovieRepository tmdbMovieRepository;

  public GetMoviesResult findByName(String name) {
    var movies = movieRepository.findFirst1ByTitleContaining(name);

    var viewModels =
        movies.stream()
            .peek(
                movie -> {
                  if (movie.getTmdbId() != null) {
                    var tmdbMovie = tmdbMovieRepository.fetchMovieDetails(movie.getTmdbId());
                    log.info(String.format("TMDB Result: %s", tmdbMovie.toString()));
                  }
                })
            .map(movieMapper::toMovieModel)
            .toList();

    return new GetMoviesResult(viewModels); // TODO what if this is null?
  }
}
