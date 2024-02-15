/* (C) 2023 */
package com.rangerforge.movieman.config;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class TmdbWebClientConfig {
  @Value("${tmdb.base-url}")
  private String tmdbBaseUrl;

  @Value("${tmdb.authorization-token}")
  private String tmdbAuthorizationToken;

  @Bean
  @Qualifier("tmdbWebClient") public WebClient tmdbWebClient() {
    return WebClient.builder()
        .baseUrl(tmdbBaseUrl)
        .defaultCookie("cookieKey", "cookieValue")
        .defaultHeaders(
            httpHeaders -> {
              httpHeaders.setBearerAuth(tmdbAuthorizationToken);
              httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
              httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            })
        .build();
  }
}
