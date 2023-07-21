/* (C) 2023 */
package com.slalombuild.movieman.tmdb;

import com.slalombuild.movieman.domain.entity.PublicMovie;
import com.slalombuild.movieman.domain.repository.PublicMovieRepository;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Service
public class TmdbMovieRepository implements PublicMovieRepository {
  public static final String DETAILS_PATH = "3/movie/${movie_id}";
  public static final String TMDB_KEY_HEADER = "";

  @Value("${rest-services.tmdb.base-url}")
  private String baseUrl;

  @Value("${rest-services.tmdb.auth-token}")
  private String authorizationToken;

  @Value("${rest-services.tmdb.timeout}")
  private Integer timeOutMillis;

  public TmdbMovieRepository() {
    var httpClient =
        HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, timeOutMillis)
            .responseTimeout(Duration.ofMillis(timeOutMillis))
            .doOnConnected(
                conn ->
                    conn.addHandlerLast(new ReadTimeoutHandler(timeOutMillis, TimeUnit.MILLISECONDS))
                        .addHandlerLast(new WriteTimeoutHandler(timeOutMillis, TimeUnit.MILLISECONDS)));

    var client =
        WebClient.builder()
            .baseUrl(baseUrl)
            .defaultCookie("cookieKey", "cookieValue")
            .defaultHeaders(httpHeaders -> {
              httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
              httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
              httpHeaders.add(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", authorizationToken));
            })
            .build();
  }

  @Override
  public PublicMovie fetchMovieDetails(Long movieId) {
    return null;
  }
}
