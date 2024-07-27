/* (C) 2023 */
package com.rangerforge.movieman.web;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import com.rangerforge.movieman.MoviemanApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SuppressWarnings("PMD.TestClassWithoutTestCases,PMD.JUnitTestsShouldIncludeAssert")
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.MOCK,
    classes = MoviemanApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("integration")
final class MovieControllerIntegrationTests {
  @Autowired private MockMvc mockMvc;

  @RegisterExtension
  static WireMockExtension wireMock =
      WireMockExtension.newInstance()
          .options(
              wireMockConfig()
                  .port(9080)
                  .usingFilesUnderDirectory("src/integration/resources/wiremock"))
          .build();

  @Test
  void givenMovies_whenGetMovies_ThenStatus200() throws Exception {
    mockMvc
        .perform(get("/movies").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.movies[0].title", containsString("Matrix")));
  }

  @Test
  void givenMovies_whenGetMovieByName_ThenStatus200() throws Exception {
    wireMock.stubFor(
        WireMock.get((urlPathMatching("/movie/[0-9]*")))
            .willReturn(
                aResponse()
                    .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .withStatus(HttpStatus.OK.value())
                    .withBodyFile("movie_603.json")));
    mockMvc
        .perform(get("/movies?name=Matrix").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.movies[0].title", containsString("Matrix")));
  }
}
