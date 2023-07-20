/* (C) 2023 */
package com.slalombuild.movieman.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.slalombuild.movieman.usecase.GetAllProjectsUseCase;
import com.slalombuild.movieman.usecase.GetProjectByNameUseCase;
import com.slalombuild.movieman.usecase.model.GetProjectResult;
import com.slalombuild.movieman.usecase.model.ProjectViewModel;
import java.util.Collections;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CastControllerTests {
  @Mock private GetAllProjectsUseCase getAllProjectsUseCase;
  @Mock private GetProjectByNameUseCase getProjectByNameUseCase;

  @InjectMocks private ProjectController controller;

  @Test
  public void givenProjects_whenGetProjects_thenCallsService() {
    // Arrange
    var expectedResults =
        new GetProjectResult(Instancio.ofList(ProjectViewModel.class).size(5).create());
    when(getAllProjectsUseCase.getAllProjects()).thenReturn(expectedResults);

    // Act
    var actualResult = controller.getProjects(null);

    // Assert
    assertThat(actualResult).isNotNull();
    verify(getAllProjectsUseCase, atLeastOnce()).getAllProjects();
  }

  @Test
  public void givenProjects_whenGetProjectByName_thenCallsService() {
    // Arrange
    var expectedResult = Instancio.of(ProjectViewModel.class).create();
    when(getProjectByNameUseCase.findByName(anyString()))
        .thenReturn(new GetProjectResult(Collections.singletonList(expectedResult)));

    // Act
    var actualResult = controller.getProjects("Cross");

    // Assert
    assertThat(actualResult).isNotNull();
    verify(getProjectByNameUseCase, atLeastOnce()).findByName("Cross");
  }
}
