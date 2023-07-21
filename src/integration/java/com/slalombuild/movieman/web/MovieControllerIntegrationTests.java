/* (C) 2023 */
package com.slalombuild.movieman.web;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.slalombuild.movieman.MoviemanApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.MOCK,
    classes = MoviemanApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test") // TODO why is application-test.yaml not loading?
public class MovieControllerIntegrationTests {
  @Autowired private MockMvc mockMvc;

  @Test
  public void givenMovies_whenGetMovies_ThenStatus200() throws Exception {
    mockMvc
        .perform(get("/movies").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.movies[0].title", containsString("Matrix")));
  }

  @Test
  public void givenMovies_whenGetMovieByName_ThenStatus200() throws Exception {
    mockMvc
        .perform(get("/movies?name=Ghost").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.movies[0].title", containsString("Ghost")));
  }
}
