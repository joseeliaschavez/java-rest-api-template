/* (C) 2023 */
package com.rangerforge.movieman.tmdb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.instancio.Select.field;

import com.rangerforge.movieman.tmdb.model.PublicMovieMapper;
import com.rangerforge.movieman.tmdb.model.TmdbMovieDetailResponse;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class PublicMovieMapperTests {
  private PublicMovieMapper publicMovieMapper;

  @BeforeEach
  void beforeEach() {
    publicMovieMapper = Mappers.getMapper(PublicMovieMapper.class);
  }

  @SuppressWarnings("PMD.JUnitTestContainsTooManyAsserts")
  @Test
  void givenTmdbMovieDetailResponse_whenToPublicMovie_shouldTransformToPublicMovie() {
    // Arrange
    var tmdbResponse =
        Instancio.of(TmdbMovieDetailResponse.class)
            .generate(field(TmdbMovieDetailResponse::getGenres), gen -> gen.collection().size(1))
            .generate(
                field(TmdbMovieDetailResponse::getProductionCompanies),
                gen -> gen.collection().size(1))
            .generate(
                field(TmdbMovieDetailResponse::getProductionCountries),
                gen -> gen.collection().size(1))
            .generate(
                field(TmdbMovieDetailResponse::getSpokenLanguages), gen -> gen.collection().size(1))
            .generate(
                field(TmdbMovieDetailResponse::getReleaseDate),
                gen -> gen.temporal().localDate().past().asString())
            .create();

    // Act
    var publicMovie = publicMovieMapper.toPublicMovie(tmdbResponse);

    // Assert
    assertThat(publicMovie).isNotNull();
    assertThat(publicMovie.getId()).isEqualTo(tmdbResponse.getId());
    assertThat(publicMovie.getTitle()).isEqualTo(tmdbResponse.getTitle());
    assertThat(publicMovie.getReleaseDate()).isEqualTo(tmdbResponse.getReleaseDate());
    assertThat(publicMovie.getDescription()).isEqualTo(tmdbResponse.getOverview());
    assertThat(publicMovie.getTagLine()).isEqualTo(tmdbResponse.getTagline());
    assertThat(publicMovie.getRuntime()).isEqualTo(tmdbResponse.getRuntime());
    assertThat(publicMovie.getBudget()).isEqualTo(tmdbResponse.getBudget());
    assertThat(publicMovie.getRevenue()).isEqualTo(tmdbResponse.getRevenue());
    assertThat(publicMovie.getGenres()).isNotEmpty();
    assertThat(publicMovie.getGenres().get(0)).isEqualTo(tmdbResponse.getGenres().get(0).getName());
    assertThat(publicMovie.getProductionCompanies()).isNotEmpty();
    assertThat(publicMovie.getProductionCompanies().get(0))
        .isEqualTo(tmdbResponse.getProductionCompanies().get(0).getName());
  }
}
