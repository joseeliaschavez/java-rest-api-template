/* (C) 2023 */
package com.slalombuild.movieman.tmdb;

import com.slalombuild.movieman.domain.entity.PublicMovie;
import com.slalombuild.movieman.domain.repository.PublicMovieRepository;
import com.slalombuild.movieman.tmdb.model.TmdbMovieDetailResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
@Slf4j
public class TmdbMovieRepository implements PublicMovieRepository {
  private final PublicMovieMapper publicMovieMapper;

  @Qualifier("tmdbWebClient") private final WebClient webClient;

  @Override
  public PublicMovie fetchMovieDetails(Long movieId) {
    return webClient
        .get()
        .uri(uriBuilder -> uriBuilder.pathSegment("movie", "{movieId}").build(movieId))
        .exchangeToMono(
            clientResponse -> {
              if (clientResponse.statusCode().is2xxSuccessful()) {
                return clientResponse
                    .bodyToMono(TmdbMovieDetailResponse.class)
                    .doOnNext(response -> log.debug("Received: " + response.toString()))
                    .map(publicMovieMapper::toPublicMovie);
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
