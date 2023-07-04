/* (C) 2023 */
package com.slalombuild.projectman.web;

import com.slalombuild.projectman.domain.entity.Project;
import com.slalombuild.projectman.domain.service.ProjectService;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
  @NonNull private ProjectService projectService;

  @GetMapping
  public List<Project> getProjects() {
    return projectService.getAllProjects();
  }
}
