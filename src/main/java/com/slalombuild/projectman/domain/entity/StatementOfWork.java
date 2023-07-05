/* (C) 2023 */
package com.slalombuild.projectman.domain.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatementOfWork {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private LocalDate startDate;
  private LocalDate endDate;

  @ManyToOne
  @JoinColumn(name = "projectId")
  private Project project;
}
