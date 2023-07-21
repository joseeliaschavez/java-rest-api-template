/* (C) 2023 */
package com.slalombuild.movieman.domain.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private LocalDate releaseDate;
  private Long tmdbId;

  @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
  private Set<Cast> cast;
}
