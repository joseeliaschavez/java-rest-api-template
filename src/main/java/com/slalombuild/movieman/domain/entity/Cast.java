/* (C) 2023 */
package com.slalombuild.movieman.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MOVIE_CAST")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cast {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String characterName;
  private String tmdbCreditId;

  @ManyToOne
  @JoinColumn(name = "movie_id")
  private Movie movie;

  @ManyToOne
  @JoinColumn(name = "actor_id")
  private Actor actor;
}
