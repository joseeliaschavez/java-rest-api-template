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
public class Actor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String fullName;
  private Long tmdbId;

  @ManyToOne
  @JoinColumn(name = "projectId")
  private Cast cast;
}
