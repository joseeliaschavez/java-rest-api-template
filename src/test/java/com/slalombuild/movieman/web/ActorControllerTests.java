/* (C) 2023 */
package com.slalombuild.movieman.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.slalombuild.movieman.usecase.GetActorByNameUseCase;
import com.slalombuild.movieman.usecase.model.ActorResultModel;
import com.slalombuild.movieman.usecase.model.GetActorsResult;
import java.util.Collections;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ActorControllerTests {
  @Mock private GetActorByNameUseCase getActorByNameUseCase;

  @InjectMocks private ActorController controller;

  @Test
  public void givenActors_whenGetByName_thenCallUseCase() {
    // Arrange
    var expectedResult = Instancio.of(ActorResultModel.class).create();
    when(getActorByNameUseCase.findByName(anyString()))
        .thenReturn(new GetActorsResult(Collections.singletonList(expectedResult)));

    // Act
    var actualResult = controller.getActors("Keanu");

    // Assert
    assertThat(actualResult).isNotNull();
    verify(getActorByNameUseCase, atLeastOnce()).findByName("Keanu");
  }
}
