/* (C) 2023 */
package com.rangerforge.movieman.tmdb.model;

import java.io.Serial;

public class TmdbException extends RuntimeException {
  @Serial private static final long serialVersionUID = 1L;

  public TmdbException(String message) {
    super(message);
  }
}
