/* (C) 2023 */
package com.slalombuild.movieman.web;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import com.slalombuild.movieman.MoviemanApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.MOCK,
    classes = MoviemanApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("integration")
public final class MovieControllerIntegrationTests {
  @Autowired private MockMvc mockMvc;

  @RegisterExtension
  static WireMockExtension wireMock =
      WireMockExtension.newInstance()
          .options(
              wireMockConfig()
                  .port(9080)
                  .usingFilesUnderDirectory("src/integration/resources/wiremock"))
          .build();

  @BeforeEach
  public void beforeEach() {
    wireMock.stubFor(
        WireMock.get((urlPathMatching("/movie/[0-9]*")))
            .willReturn(
                aResponse()
                    .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .withBodyFile("movie_603.json")));
  }

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
        .perform(get("/movies?name=Matrix").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.movies[0].title", containsString("Matrix")));
  }
}
