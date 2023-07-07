/* (C) 2023 */
package com.slalombuild.projectman.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.slalombuild.projectman.usecase.GetAllProjectsResult;
import com.slalombuild.projectman.usecase.GetAllProjectsUseCase;
import com.slalombuild.projectman.usecase.model.ProjectViewModel;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProjectControllerTests {
  @Mock private GetAllProjectsUseCase useCase;

  @InjectMocks private ProjectController controller;

  @Test
  public void givenProjects_whenGetProjects_thenCallsService() {
    // Arrange
    var expectedResults =
        new GetAllProjectsResult(Instancio.ofList(ProjectViewModel.class).size(5).create());
    when(useCase.getAllProjects()).thenReturn(expectedResults);

    // Act
    var actualResult = controller.getProjects();

    // Assert
    assertThat(actualResult).isNotNull();
    verify(useCase, atLeastOnce()).getAllProjects();
  }
}
