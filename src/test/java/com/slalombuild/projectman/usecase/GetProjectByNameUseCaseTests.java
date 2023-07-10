/* (C) 2023 */
package com.slalombuild.projectman.usecase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.slalombuild.projectman.domain.entity.Project;
import com.slalombuild.projectman.domain.repository.ProjectRepository;
import java.util.Collections;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GetProjectByNameUseCaseTests {
  @Mock private ProjectRepository projectRepository;

  @InjectMocks private GetProjectByNameUseCase useCase;

  @Test
  public void givenProjects_whenGetAllProjects_thenReturnList() {
    // Arrange
    var searchName = "Cross";
    var expectedResult = Instancio.of(Project.class).create();
    when(projectRepository.findFirst1ByNameStartingWith(searchName))
        .thenReturn(Collections.singletonList(expectedResult));

    // Act
    var actualResult = useCase.findByName(searchName);

    // Assert
    verify(projectRepository, atLeastOnce()).findFirst1ByNameStartingWith(searchName);

    assertThat(actualResult).isNotNull();
    assertThat(actualResult.getProjects()).isNotEmpty();
    assertThat(actualResult.getProjects().size()).isEqualTo(1);
  }
}
