/* (C) 2023 */
package com.rangerforge.movieman.usecase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.instancio.Select.field;
import static org.mockito.Mockito.*;

import com.rangerforge.movieman.domain.entity.Movie;
import com.rangerforge.movieman.domain.repository.MovieRepository;
import com.rangerforge.movieman.usecase.model.MovieResultModel;
import java.util.Collections;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetAllMoviesUseCaseTests {
  @Mock private MovieMapper movieMapper;
  @Mock private MovieRepository movieRepository;
  @InjectMocks private GetAllMoviesUseCase useCase;

  @Test
  void givenMovies_whenGetAllMovies_thenReturnList() {
    // Arrange
    var expectedResults = Instancio.ofList(Movie.class).size(5).create();
    when(movieRepository.findAll()).thenReturn(expectedResults);
    when(movieMapper.toMovieModel(any(Movie.class)))
        .thenReturn(Instancio.of(MovieResultModel.class).create());

    // Act
    var actualResult = useCase.getAllMovies();

    // Assert
    verify(movieRepository, atLeastOnce()).findAll();

    assertThat(actualResult).isNotNull();
    assertThat(actualResult.getMovies()).isNotEmpty();
    assertThat(actualResult.getMovies().size()).isEqualTo(5);
  }

  @Test
  void givenMovies_whenGetAllMovies_thenMappingIsCorrect() {
    // Arrange
    var expectedResult =
        Instancio.of(Movie.class)
            .generate(field(Movie::getCast), gen -> gen.collection().size(1))
            .create();
    when(movieRepository.findAll()).thenReturn(Collections.singletonList(expectedResult));

    // Act
    var actualResults = useCase.getAllMovies();

    // Assert
    verify(movieRepository, atLeastOnce()).findAll();
    assertThat(actualResults).isNotNull();
  }
}
