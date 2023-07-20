/* (C) 2023 */
package com.slalombuild.movieman.domain.repository;

import com.slalombuild.movieman.domain.entity.Cast;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Cast, Long> {
  List<Cast> findFirst1ByNameStartingWith(String prefix);
}
