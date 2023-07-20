/* (C) 2023 */
package com.slalombuild.movieman.domain.repository;

import com.slalombuild.movieman.domain.entity.Project;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
  List<Project> findFirst1ByNameStartingWith(String prefix);
}
