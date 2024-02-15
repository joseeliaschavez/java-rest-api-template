/* (C) 2023 */
package com.rangerforge.movieman.usecase.model;

import java.time.LocalDate;
import java.util.List;
import lombok.Value;

@Value
public class MovieResultModel {
  long id;
  String title;
  LocalDate releaseDate;
  List<CastResultModel> cast;
}
