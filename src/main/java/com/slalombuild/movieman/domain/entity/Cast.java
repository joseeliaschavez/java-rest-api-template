/* (C) 2023 */
package com.slalombuild.movieman.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cast {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String characterName;
  private Long tmdbId;

  @ManyToOne
  @JoinColumn(name = "movieId")
  private Movie movie;

  @ManyToOne
  @JoinColumn(name = "actorId")
  private Actor actor;
}
