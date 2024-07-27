/* (C) 2023 */
package com.rangerforge.movieman;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@SuppressWarnings("PMD.TestClassWithoutTestCases")
@AnalyzeClasses(packages = {"com.rangerforge.movieman"})
public class CleanArchitectureTests {
  @ArchTest
  static final ArchRule onion_architecture_is_respected =
      onionArchitecture()
          .domainModels("..domain.entity..")
          .domainServices("..domain.repository..")
          .applicationServices("..usecase..")
          .adapter("http", "..tmdb..")
          .adapter("rest", "..web..");
}
