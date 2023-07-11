/* (C) 2023 */
package com.slalombuild.projectman.web;

import com.slalombuild.projectman.usecase.GetAllProjectsUseCase;
import com.slalombuild.projectman.usecase.GetProjectByNameUseCase;
import com.slalombuild.projectman.usecase.model.GetProjectResult;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
  @NonNull private GetAllProjectsUseCase getAllProjectsUseCase;
  @NonNull private GetProjectByNameUseCase getProjectByNameUseCase;

  @GetMapping
  public GetProjectResult getProjects(@RequestParam(required = false) @Nullable String name) {
    if (name != null && !name.isEmpty()) return getProjectByNameUseCase.findByName(name);
    return getAllProjectsUseCase.getAllProjects();
  }
}
