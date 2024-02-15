/* (C) 2023 */
package com.rangerforge.movieman.usecase;

import com.rangerforge.movieman.domain.entity.Cast;
import com.rangerforge.movieman.domain.entity.Movie;
import com.rangerforge.movieman.usecase.model.CastResultModel;
import com.rangerforge.movieman.usecase.model.MovieResultModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MovieMapper {
  MovieResultModel toMovieModel(Movie movie);

  @Mapping(source = "cast.actor.fullName", target = "actorName")
  CastResultModel toCastModel(Cast cast);
}
