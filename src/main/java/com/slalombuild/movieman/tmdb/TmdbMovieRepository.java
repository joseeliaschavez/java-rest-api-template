/* (C) 2023 */
package com.slalombuild.movieman.tmdb;

import com.slalombuild.movieman.tmdb.model.TmdbMovieDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TmdbMovieRepository {
  @Qualifier("tmdbWebClient") private final WebClient webClient;

  public TmdbMovieDetailResponse fetchMovieDetails(Long movieId) {
    return webClient
        .get()
        .uri(uriBuilder -> uriBuilder.pathSegment("movie", "{movieId}").build(movieId))
        .exchangeToMono(
            clientResponse -> {
              if (clientResponse.statusCode().is2xxSuccessful()) {
                return clientResponse.bodyToMono(TmdbMovieDetailResponse.class);
              }

              return clientResponse
                  .bodyToMono(String.class)
                  .flatMap(
                      body ->
                          Mono.error(
                              new TmdbException(
                                  String.format(
                                      "Request failed with status code: %s, body: %s",
                                      clientResponse.statusCode(), body))));
            })
        .block();
  }
}
