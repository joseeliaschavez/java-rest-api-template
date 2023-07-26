/* (C) 2023 */
package com.slalombuild.movieman.usecase;

import com.slalombuild.movieman.domain.entity.Cast;
import com.slalombuild.movieman.domain.entity.Movie;
import com.slalombuild.movieman.usecase.model.CastResultModel;
import com.slalombuild.movieman.usecase.model.MovieResultModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MovieMapper {
  MovieResultModel toMovieModel(Movie movie);

  @Mapping(source = "cast.actor.fullName", target = "actorName")
  CastResultModel toCastModel(Cast cast);
}
