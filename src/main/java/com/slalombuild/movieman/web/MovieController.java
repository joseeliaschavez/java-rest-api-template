/* (C) 2023 */
package com.slalombuild.movieman.web;

import com.slalombuild.movieman.usecase.GetAllMoviesUseCase;
import com.slalombuild.movieman.usecase.GetMovieByNameUseCase;
import com.slalombuild.movieman.usecase.model.GetMoviesResult;
import lombok.NonNull;
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
  @NonNull private GetAllMoviesUseCase getAllMoviesUseCase;
  @NonNull private GetMovieByNameUseCase getMovieByNameUseCase;

  @GetMapping
  public GetMoviesResult getMovies(@RequestParam(required = false) @Nullable String name) {
    if (name != null && !name.isEmpty()) {
      return getMovieByNameUseCase.findByName(name);
    }
    return getAllMoviesUseCase.getAllMovies();
  }
}
