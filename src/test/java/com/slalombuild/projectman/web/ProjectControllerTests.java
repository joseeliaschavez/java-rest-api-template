/* (C) 2023 */
package com.slalombuild.projectman.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.slalombuild.projectman.domain.entity.Project;
import com.slalombuild.projectman.domain.service.ProjectService;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProjectControllerTests {
  @Mock private ProjectService projectService;

  @InjectMocks private ProjectController controller;

  @Test
  public void givenProjects_whenGetProjects_thenCallsService() {
    // Arrange
    var expectedResults = Instancio.ofList(Project.class).size(5).create();
    when(projectService.getAllProjects()).thenReturn(expectedResults);

    // Act
    var actualResult = controller.getProjects();

    // Assert
    assertThat(actualResult).isNotNull();
    verify(projectService, atLeastOnce()).getAllProjects();
  }
}
