/* (C) 2023 */
package com.rangerforge.movieman.usecase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.instancio.Select.field;
import static org.mockito.Mockito.*;

import com.rangerforge.movieman.domain.entity.Movie;
import com.rangerforge.movieman.domain.entity.PublicMovie;
import com.rangerforge.movieman.domain.repository.MovieRepository;
import com.rangerforge.movieman.domain.repository.PublicMovieRepository;
import com.rangerforge.movieman.usecase.model.MovieResultModel;
import java.util.Collections;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetMovieByNameUseCaseTests {
  @Mock private MovieMapper movieMapper;
  @Mock private MovieRepository movieRepository;
  @Mock private PublicMovieRepository publicMovieRepository;
  @InjectMocks private GetMovieByNameUseCase useCase;

  @Test
  void givenMovies_whenFindByName_thenReturnList() {
    // Arrange
    var searchName = "Ghost";
    var movie = Instancio.of(Movie.class).ignore(field(Movie::getTmdbId)).create();
    when(movieRepository.findFirst1ByTitleContaining(searchName))
        .thenReturn(Collections.singletonList(movie));
    when(movieMapper.toMovieModel(any(Movie.class)))
        .thenReturn(Instancio.of(MovieResultModel.class).create());

    // Act
    var actualResult = useCase.findByName(searchName);

    // Assert
    verify(movieRepository, atLeastOnce()).findFirst1ByTitleContaining(searchName);
    verify(movieMapper, atLeastOnce()).toMovieModel(movie);

    assertThat(actualResult).isNotNull();
    assertThat(actualResult.getMovies()).isNotEmpty();
    assertThat(actualResult.getMovies().size()).isEqualTo(1);
  }

  @Test
  void givenMovies_whenFindByName_thenFetchMovieDetailsCalled() {
    // Arrange
    var searchName = "Ghost";
    var movie = Instancio.of(Movie.class).create();
    var publicMovie = Instancio.of(PublicMovie.class).create();
    when(movieRepository.findFirst1ByTitleContaining(searchName))
        .thenReturn(Collections.singletonList(movie));
    when(publicMovieRepository.fetchMovieDetails(anyLong())).thenReturn(publicMovie);
    when(movieMapper.toMovieModel(any(Movie.class)))
        .thenReturn(Instancio.of(MovieResultModel.class).create());

    // Act
    useCase.findByName(searchName);

    // Assert
    verify(publicMovieRepository, atLeastOnce()).fetchMovieDetails(anyLong());
  }
}
