/* (C) 2023 */
package com.slalombuild.movieman.usecase.model;

import java.time.LocalDate;
import lombok.Value;

@Value
public class ProjectViewModel {
  long id;
  String name;
  LocalDate startDate;
  LocalDate endDate;
  String clientName;
  String marketName;
}
