/* (C) 2023 */
package com.slalombuild.movieman;

import static org.assertj.core.api.Assertions.assertThat;

import com.slalombuild.movieman.web.MovieController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MoviemanApplicationTests {
  @Autowired private MovieController movieController;

  @Test
  void contextLoads() {
    assertThat(movieController).isNotNull();
  }
}
