/* (C) 2023 */
package com.rangerforge.movieman.tmdb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.Value;

@SuppressWarnings("PMD.TooManyFields")
@JsonNaming(
    PropertyNamingStrategies.SnakeCaseStrategy.class) // Use snake case to camel case conversion
@NoArgsConstructor(force = true)
@Value
public class TmdbMovieDetailResponse {
  boolean adult;
  String backdropPath; // Use camel case for variable name
  BelongsToCollection belongsToCollection;
  int budget;
  List<Genre> genres;
  String homepage;
  int id;
  String imdbId; // Use camel case for variable name
  String originalLanguage; // Use camel case for variable name
  String originalTitle; // Use camel case for variable name
  String overview;
  double popularity;
  String posterPath; // Use camel case for variable name
  List<ProductionCompany> productionCompanies; // Use camel case for variable name
  List<ProductionCountry> productionCountries; // Use camel case for variable name
  String releaseDate; // Use camel case for variable name
  int revenue;
  int runtime;
  List<SpokenLanguage> spokenLanguages; // Use camel case for variable name
  String status;
  String tagline;
  String title;
  boolean video;
  double voteAverage; // Use camel case for variable name
  int voteCount; // Use camel case for variable name

  @NoArgsConstructor(force = true)
  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  @Value
  public static class BelongsToCollection {
    int id;
    String name;
    String posterPath;
    String backdropPath;
  }

  @NoArgsConstructor(force = true)
  @Value
  public static class Genre {
    int id;
    String name;
  }

  @NoArgsConstructor(force = true)
  @Value
  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class ProductionCompany {
    int id;
    String logo_path;
    String name;
    String origin_country;
  }

  @NoArgsConstructor(force = true)
  @Value
  public static class ProductionCountry {
    @JsonProperty("iso_3166_1")
    String iso31661;

    String name;
  }

  @NoArgsConstructor(force = true)
  @Value
  public static class SpokenLanguage {
    @JsonProperty("english_name")
    String englishName;

    @JsonProperty("iso_639_1")
    String iso6391;

    String name;
  }
}
