/* (C) 2023 */
package com.rangerforge.movieman.tmdb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.instancio.Select.field;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rangerforge.movieman.tmdb.model.PublicMovieMapper;
import com.rangerforge.movieman.tmdb.model.TmdbMovieDetailResponse;
import com.rangerforge.movieman.tmdb.model.TmdbMovieRepository;
import java.io.IOException;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.instancio.Instancio;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@ExtendWith(MockitoExtension.class)
class TmdbMovieRepositoryTests {
  private ObjectMapper objectMapper;
  private MockWebServer mockWebServer;
  private TmdbMovieRepository movieRepository;

  @BeforeEach
  void beforeEach() throws IOException {
    objectMapper = new ObjectMapper();
    mockWebServer = new MockWebServer();
    mockWebServer.start();

    var mapper = Mappers.getMapper(PublicMovieMapper.class);
    var webClient =
        WebClient.builder()
            .baseUrl(String.format("http://localhost:%s", mockWebServer.getPort()))
            .build();
    movieRepository = new TmdbMovieRepository(mapper, webClient);
  }

  @AfterEach
  void afterEach() throws IOException {
    mockWebServer.shutdown();
  }

  @Test
  void givenMovieId_whenFetchMovieDetails_shouldReturnMovie()
      throws IOException, InterruptedException {
    // Arrange
    var tmdbResponse =
        Instancio.of(TmdbMovieDetailResponse.class)
            .generate(
                field(TmdbMovieDetailResponse::getReleaseDate),
                gen -> gen.temporal().localDate().past().asString())
            .create();
    var body = objectMapper.writeValueAsString(tmdbResponse);
    mockWebServer.enqueue(
        new MockResponse()
            .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .setBody(body));

    // Act
    var response = movieRepository.fetchMovieDetails(603L);

    // Assert
    assertThat(response).isNotNull();
    var recordedRequest = mockWebServer.takeRequest();
    assertThat(recordedRequest.getMethod()).isEqualToIgnoringCase("get");
    assertThat(recordedRequest.getPath()).isEqualTo("/movie/603");
  }
}
