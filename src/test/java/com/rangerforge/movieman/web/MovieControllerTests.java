/* (C) 2023 */
package com.rangerforge.movieman.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.rangerforge.movieman.usecase.GetAllMoviesUseCase;
import com.rangerforge.movieman.usecase.GetMovieByNameUseCase;
import com.rangerforge.movieman.usecase.model.GetMoviesResult;
import com.rangerforge.movieman.usecase.model.MovieResultModel;
import java.util.Collections;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MovieControllerTests {
  @Mock private GetAllMoviesUseCase getAllMoviesUseCase;
  @Mock private GetMovieByNameUseCase getMovieByNameUseCase;

  @InjectMocks private MovieController controller;

  @Test
  void givenMovies_whenGetMovies_thenCallsService() {
    // Arrange
    var expectedResults =
        new GetMoviesResult(Instancio.ofList(MovieResultModel.class).size(5).create());
    when(getAllMoviesUseCase.getAllMovies()).thenReturn(expectedResults);

    // Act
    var actualResult = controller.getMovies(null);

    // Assert
    assertThat(actualResult).isNotNull();
    verify(getAllMoviesUseCase, atLeastOnce()).getAllMovies();
  }

  @Test
  void givenMovies_whenGetMovieByName_thenCallsService() {
    // Arrange
    var expectedResult = Instancio.of(MovieResultModel.class).create();
    when(getMovieByNameUseCase.findByName(anyString()))
        .thenReturn(new GetMoviesResult(Collections.singletonList(expectedResult)));

    // Act
    var actualResult = controller.getMovies("Cross");

    // Assert
    assertThat(actualResult).isNotNull();
    verify(getMovieByNameUseCase, atLeastOnce()).findByName("Cross");
  }
}
