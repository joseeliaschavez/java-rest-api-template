/* (C) 2023 */
package com.slalombuild.movieman.usecase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.slalombuild.movieman.domain.entity.Movie;
import com.slalombuild.movieman.domain.repository.MovieRepository;
import java.util.Collections;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GetMovieByNameUseCaseTests {
  @Mock private MovieRepository movieRepository;

  @InjectMocks private GetMovieByNameUseCase useCase;

  @Test
  public void givenMovies_whenGetAllMovies_thenReturnList() {
    // Arrange
    var searchName = "Cross";
    var expectedResult = Instancio.of(Movie.class).create();
    when(movieRepository.findFirst1ByNameStartingWith(searchName))
        .thenReturn(Collections.singletonList(expectedResult));

    // Act
    var actualResult = useCase.findByName(searchName);

    // Assert
    verify(movieRepository, atLeastOnce()).findFirst1ByNameStartingWith(searchName);

    assertThat(actualResult).isNotNull();
    assertThat(actualResult.getMovies()).isNotEmpty();
    assertThat(actualResult.getMovies().size()).isEqualTo(1);
  }
}
