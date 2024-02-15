/* (C) 2023 */
package com.rangerforge.movieman.domain.repository;

import com.rangerforge.movieman.domain.entity.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
  List<Movie> findFirst1ByTitleContaining(String prefix);
}
