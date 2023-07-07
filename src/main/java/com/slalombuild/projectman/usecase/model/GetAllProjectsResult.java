/* (C) 2023 */
package com.slalombuild.projectman.usecase.model;

import java.util.List;
import lombok.NonNull;
import lombok.Value;

@Value
public class GetAllProjectsResult {
  @NonNull private List<ProjectViewModel> projects;
}
