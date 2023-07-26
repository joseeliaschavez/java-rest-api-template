/* (C) 2023 */
package com.slalombuild.movieman.domain.repository;

import com.slalombuild.movieman.domain.entity.PublicMovie;

public interface PublicMovieRepository {
  PublicMovie fetchMovieDetails(Long movieId);
}
