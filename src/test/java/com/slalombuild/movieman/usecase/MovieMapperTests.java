/* (C) 2023 */
package com.slalombuild.movieman.usecase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.instancio.Select.field;

import com.slalombuild.movieman.domain.entity.Movie;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

public class MovieMapperTests {
  private MovieMapper movieMapper;

  @BeforeEach
  public void beforeEach() {
    movieMapper = Mappers.getMapper(MovieMapper.class);
  }

  @Test
  public void givenMovie_whenToMovieModel_shouldReturnResultModel() {
    // Arrange
    var movie =
        Instancio.of(Movie.class)
            .generate(field(Movie::getCast), gen -> gen.collection().size(1))
            .create();

    // Act
    var actualResult = movieMapper.toMovieModel(movie);

    // Assert
    assertThat(actualResult.getId()).isEqualTo(movie.getId());
    assertThat(actualResult.getTitle()).isEqualTo(movie.getTitle());
    assertThat(actualResult.getReleaseDate()).isEqualTo(movie.getReleaseDate());
    assertThat(actualResult.getCast()).isNotNull();
    assertThat(actualResult.getCast()).isNotEmpty();

    var expectedCast = movie.getCast().iterator().next();
    var actualCast = actualResult.getCast().get(0);

    assertThat(actualCast.getActorName()).isEqualTo(expectedCast.getActor().getFullName());
    assertThat(actualCast.getCharacterName()).isEqualTo(expectedCast.getCharacterName());
  }
}
