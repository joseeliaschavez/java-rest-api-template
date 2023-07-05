/* (C) 2023 */
package com.slalombuild.projectman.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consultant {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String firstName;
  private String lastName;

  @Enumerated(EnumType.STRING)
  private Capability capability;

  @ManyToOne
  @JoinColumn(name = "marketId")
  private Market market;

  @ManyToOne
  @JoinColumn(name = "statement_of_work_id")
  private StatementOfWork statementOfWork;
}
