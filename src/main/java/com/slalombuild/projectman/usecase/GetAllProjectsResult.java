/* (C) 2023 */
package com.slalombuild.projectman.usecase;

import com.slalombuild.projectman.usecase.model.ProjectViewModel;
import java.util.List;
import lombok.NonNull;
import lombok.Value;

@Value
public class GetAllProjectsResult {
  @NonNull private List<ProjectViewModel> projects;
}
