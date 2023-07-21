/* (C) 2023 */
package com.slalombuild.movieman.usecase.model;

import com.slalombuild.movieman.domain.entity.Cast;
import com.slalombuild.movieman.domain.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {
  MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

  MovieResultModel toMovieModel(Movie movie);

  @Mapping(source = "cast.actor.fullName", target = "actorName")
  CastResultModel toCastModel(Cast cast);
}
