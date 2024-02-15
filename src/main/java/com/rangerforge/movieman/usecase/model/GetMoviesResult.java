/* (C) 2023 */
package com.rangerforge.movieman.usecase.model;

import java.util.List;
import lombok.Value;

@Value
public class GetMoviesResult {
  List<MovieResultModel> movies;
}
