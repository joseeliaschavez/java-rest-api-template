/* (C) 2023 */
package com.slalombuild.movieman.domain.repository;

import com.slalombuild.movieman.domain.entity.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
  List<Movie> findFirst1ByNameStartingWith(String prefix);
}
