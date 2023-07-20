/* (C) 2023 */
package com.slalombuild.movieman.usecase;

import com.slalombuild.movieman.domain.repository.ProjectRepository;
import com.slalombuild.movieman.usecase.model.GetProjectResult;
import com.slalombuild.movieman.usecase.model.ProjectMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProjectByNameUseCase {
  @NonNull private ProjectRepository projectRepository;

  public GetProjectResult findByName(String name) {
    var results = projectRepository.findFirst1ByNameStartingWith(name);

    var viewModels = results.stream().map(ProjectMapper.INSTANCE::toViewModel).toList();

    return new GetProjectResult(viewModels); // TODO what if this is null?
  }
}
