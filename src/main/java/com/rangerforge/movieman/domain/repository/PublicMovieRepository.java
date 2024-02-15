/* (C) 2023 */
package com.rangerforge.movieman.domain.repository;

import com.rangerforge.movieman.domain.entity.PublicMovie;

public interface PublicMovieRepository {
  PublicMovie fetchMovieDetails(Long movieId);
}
