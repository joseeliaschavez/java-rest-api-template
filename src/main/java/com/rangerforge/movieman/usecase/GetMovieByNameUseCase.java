/* (C) 2023 */
package com.rangerforge.movieman.usecase;

import com.rangerforge.movieman.domain.repository.MovieRepository;
import com.rangerforge.movieman.domain.repository.PublicMovieRepository;
import com.rangerforge.movieman.usecase.model.GetMoviesResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class GetMovieByNameUseCase {
  private final MovieMapper movieMapper;
  private final MovieRepository movieRepository;
  private final PublicMovieRepository publicMovieRepository;

  public GetMoviesResult findByName(String name) {
    var movies = movieRepository.findFirst1ByTitleContaining(name);

    var viewModels =
        movies.stream()
            .peek(
                movie -> {
                  if (movie.getTmdbId() != null) {
                    var tmdbMovie = publicMovieRepository.fetchMovieDetails(movie.getTmdbId());
                    if (log.isInfoEnabled()) log.info("TMDB Result: {}", tmdbMovie.toString());
                  }
                })
            .map(movieMapper::toMovieModel)
            .toList();

    return new GetMoviesResult(viewModels); // TODO what if this is null?
  }
}
