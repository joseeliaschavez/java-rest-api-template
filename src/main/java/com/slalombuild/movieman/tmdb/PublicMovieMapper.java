/* (C) 2023 */
package com.slalombuild.movieman.tmdb;

import com.slalombuild.movieman.domain.entity.PublicMovie;
import com.slalombuild.movieman.tmdb.model.TmdbMovieDetailResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PublicMovieMapper {
  @Mapping(source = "response.overview", target = "description")
  @Mapping(source = "response.tagline", target = "tagLine")
  PublicMovie toPublicMovie(TmdbMovieDetailResponse response);

  default List<String> mapProductionCompanies(
      List<TmdbMovieDetailResponse.ProductionCompany> productionCompanies) {
    return productionCompanies.stream()
        .map(TmdbMovieDetailResponse.ProductionCompany::getName)
        .toList();
  }

  default List<String> mapGenres(List<TmdbMovieDetailResponse.Genre> genres) {
    return genres.stream().map(TmdbMovieDetailResponse.Genre::getName).toList();
  }
}
