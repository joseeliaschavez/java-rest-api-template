/* (C) 2023 */
package com.slalombuild.projectman;

import static org.assertj.core.api.Assertions.assertThat;

import com.slalombuild.projectman.web.ProjectController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectmanApplicationTests {
  @Autowired private ProjectController projectController;

  @Test
  void contextLoads() {
    assertThat(projectController).isNotNull();
  }
}
