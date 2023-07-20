/* (C) 2023 */
package com.slalombuild.movieman.usecase.model;

import com.slalombuild.movieman.domain.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {
  ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

  @Mapping(source = "project.client.name", target = "clientName")
  @Mapping(source = "project.market.name", target = "marketName")
  ProjectViewModel toViewModel(Project project);
}
