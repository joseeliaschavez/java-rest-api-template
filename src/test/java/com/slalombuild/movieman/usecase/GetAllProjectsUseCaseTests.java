/* (C) 2023 */
package com.slalombuild.movieman.usecase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.slalombuild.movieman.domain.entity.Cast;
import com.slalombuild.movieman.domain.repository.ProjectRepository;
import java.util.Collections;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GetAllProjectsUseCaseTests {
  @Mock private ProjectRepository projectRepository;

  @InjectMocks private GetAllProjectsUseCase useCase;

  @Test
  public void givenProjects_whenGetAllProjects_thenReturnList() {
    // Arrange
    var expectedResults = Instancio.ofList(Cast.class).size(5).create();
    when(projectRepository.findAll()).thenReturn(expectedResults);

    // Act
    var actualResult = useCase.getAllProjects();

    // Assert
    verify(projectRepository, atLeastOnce()).findAll();

    assertThat(actualResult).isNotNull();
    assertThat(actualResult.getProjects()).isNotEmpty();
    assertThat(actualResult.getProjects().size()).isEqualTo(5);
  }

  @Test
  public void givenProjects_whenGetAllProjects_thenMappingIsCorrect() {
    // Arrange
    var expectedResult = Instancio.of(Cast.class).create();
    when(projectRepository.findAll()).thenReturn(Collections.singletonList(expectedResult));

    // Act
    var actualResults = useCase.getAllProjects();

    // Assert
    verify(projectRepository, atLeastOnce()).findAll();

    var actualResult = actualResults.getProjects().get(0);

    assertThat(actualResult.getId()).isEqualTo(expectedResult.getId());
    assertThat(actualResult.getName()).isEqualTo(expectedResult.getName());
    assertThat(actualResult.getStartDate()).isEqualTo(expectedResult.getStartDate());
    assertThat(actualResult.getEndDate()).isEqualTo(expectedResult.getEndDate());
    assertThat(actualResult.getClientName()).isEqualTo(expectedResult.getMovie().getName());
    assertThat(actualResult.getMarketName()).isEqualTo(expectedResult.getMarket().getName());
  }
}
