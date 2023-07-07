/* (C) 2023 */
package com.slalombuild.projectman.web;

import com.slalombuild.projectman.usecase.GetAllProjectsResult;
import com.slalombuild.projectman.usecase.GetAllProjectsUseCase;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
  @NonNull private GetAllProjectsUseCase getAllProjectsUseCase;

  @GetMapping
  public GetAllProjectsResult getProjects() {
    return getAllProjectsUseCase.getAllProjects();
  }
}
