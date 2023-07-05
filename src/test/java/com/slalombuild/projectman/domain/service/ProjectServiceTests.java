/* (C) 2023 */
package com.slalombuild.projectman.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.slalombuild.projectman.domain.entity.Project;
import com.slalombuild.projectman.domain.repository.ProjectRepository;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceTests {
  @Mock private ProjectRepository projectRepository;

  @InjectMocks private ProjectService service;

  @Test
  public void givenProjects_whenGetAllProjects_thenReturnList() {
    // Arrange
    var expectedResults = Instancio.ofList(Project.class).size(5).create();
    when(projectRepository.findAll()).thenReturn(expectedResults);

    // Act
    var actualResult = service.getAllProjects();

    // Assert
    assertThat(actualResult).isNotNull();
    verify(projectRepository, atLeastOnce()).findAll();
  }
}
