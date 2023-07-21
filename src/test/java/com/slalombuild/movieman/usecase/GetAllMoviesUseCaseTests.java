/* (C) 2023 */
package com.slalombuild.movieman.usecase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.instancio.Select.field;
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
public class GetAllMoviesUseCaseTests {
  @Mock private MovieRepository movieRepository;

  @InjectMocks private GetAllMoviesUseCase useCase;

  @Test
  public void givenMovies_whenGetAllMovies_thenReturnList() {
    // Arrange
    var expectedResults = Instancio.ofList(Movie.class).size(5).create();
    when(movieRepository.findAll()).thenReturn(expectedResults);

    // Act
    var actualResult = useCase.getAllMovies();

    // Assert
    verify(movieRepository, atLeastOnce()).findAll();

    assertThat(actualResult).isNotNull();
    assertThat(actualResult.getMovies()).isNotEmpty();
    assertThat(actualResult.getMovies().size()).isEqualTo(5);
  }

  @Test
  public void givenMovies_whenGetAllMovies_thenMappingIsCorrect() {
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

    var actualResult = actualResults.getMovies().get(0);

    assertThat(actualResult.getId()).isEqualTo(expectedResult.getId());
    assertThat(actualResult.getName()).isEqualTo(expectedResult.getName());
    assertThat(actualResult.getReleaseDate()).isEqualTo(expectedResult.getReleaseDate());
    assertThat(actualResult.getCast()).isNotNull();
    assertThat(actualResult.getCast()).isNotEmpty();

    var expectedCast = expectedResult.getCast().iterator().next();
    var actualCast = actualResult.getCast().get(0);

    assertThat(actualCast.getActorName()).isEqualTo(expectedCast.getActor().getFullName());
    assertThat(actualCast.getCharacterName()).isEqualTo(expectedCast.getCharacterName());
  }
}
