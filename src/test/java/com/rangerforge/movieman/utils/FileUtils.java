/* (C) 2023 */
package com.rangerforge.movieman.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class FileUtils {
  private FileUtils() {}

  public static String asString(String pathToFile) throws IOException {
    Path path = Paths.get(pathToFile);
    return Files.readAllLines(path).get(0);
  }
}
