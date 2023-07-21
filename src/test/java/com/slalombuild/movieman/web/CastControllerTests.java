/* (C) 2023 */
package com.slalombuild.movieman.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.slalombuild.movieman.usecase.GetAllMoviesUseCase;
import com.slalombuild.movieman.usecase.GetMovieByNameUseCase;
import com.slalombuild.movieman.usecase.model.GetMoviesResult;
import com.slalombuild.movieman.usecase.model.MovieResultModel;
import java.util.Collections;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CastControllerTests {
  @Mock private GetAllMoviesUseCase getAllMoviesUseCase;
  @Mock private GetMovieByNameUseCase getMovieByNameUseCase;

  @InjectMocks private MovieController controller;

  @Test
  public void givenMovies_whenGetMovies_thenCallsService() {
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
  public void givenMovies_whenGetMovieByName_thenCallsService() {
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
