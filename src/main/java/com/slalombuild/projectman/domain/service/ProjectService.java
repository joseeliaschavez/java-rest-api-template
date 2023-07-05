/* (C) 2023 */
package com.slalombuild.projectman.domain.service;

import com.slalombuild.projectman.domain.entity.Project;
import com.slalombuild.projectman.domain.repository.ProjectRepository;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {
  @NonNull private ProjectRepository projectRepository;

  public List<Project> getAllProjects() {
    return projectRepository.findAll();
  }
}
