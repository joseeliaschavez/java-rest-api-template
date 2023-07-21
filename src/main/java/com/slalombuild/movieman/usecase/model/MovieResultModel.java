/* (C) 2023 */
package com.slalombuild.movieman.usecase.model;

import java.time.LocalDate;
import java.util.List;
import lombok.Value;

@Value
public class MovieResultModel {
  long id;
  String name;
  LocalDate releaseDate;
  List<CastResultModel> cast;
}
