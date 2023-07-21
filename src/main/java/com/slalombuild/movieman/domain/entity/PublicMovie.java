/* (C) 2023 */
package com.slalombuild.movieman.domain.entity;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicMovie {
  Long id;
  String title;
  String description;
  String tagLine;
  Long budget;
  Long revenue;
  Integer runtime;
  LocalDate releaseDate;
  List<String> productionCompanies;
  List<String> genres;
}
