/* (C) 2023 */
package com.slalombuild.movieman.usecase;

import com.slalombuild.movieman.usecase.model.GetActorsResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetActorByNameUseCase {
  public GetActorsResult findByName(String name) {
    return null; // TODO Implement me!
  }
}
