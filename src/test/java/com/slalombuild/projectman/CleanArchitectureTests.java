/* (C) 2023 */
package com.slalombuild.projectman;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packages = {"com.slalombuild.projectman"})
public class CleanArchitectureTests {
  @ArchTest
  static final ArchRule onion_architecture_is_respected =
      onionArchitecture()
          .domainModels("..domain.entity..")
          .domainServices("..domain.repository..")
          .applicationServices("..usecase..")
          .adapter("rest", "..web..");
}
