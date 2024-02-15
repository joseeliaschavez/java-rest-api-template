/* (C) 2023 */
package com.rangerforge.movieman.web;

import com.rangerforge.movieman.usecase.GetAllMoviesUseCase;
import com.rangerforge.movieman.usecase.GetMovieByNameUseCase;
import com.rangerforge.movieman.usecase.model.GetMoviesResult;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
  private final GetAllMoviesUseCase getAllMoviesUseCase;
  private final GetMovieByNameUseCase getMovieByNameUseCase;

  @GetMapping
  public GetMoviesResult getMovies(@RequestParam(required = false) @Nullable String name) {
    if (name != null && !name.isEmpty()) {
      return getMovieByNameUseCase.findByName(name);
    }
    return getAllMoviesUseCase.getAllMovies();
  }
}
