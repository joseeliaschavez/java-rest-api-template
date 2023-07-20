/* (C) 2023 */
package com.slalombuild.movieman.usecase.model;

import java.util.List;
import lombok.NonNull;
import lombok.Value;

@Value
public class GetProjectResult {
  @NonNull private List<ProjectViewModel> projects;
}
