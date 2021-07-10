package com.christian.market.persistence.mapper;

import com.christian.market.domain.Category;
import com.christian.market.persistence.entity.Categoria;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
  @Mappings({
    @Mapping(source = "idCategoria", target = "categoryId"),
    @Mapping(source = "description", target = "category"),
    @Mapping(source = "estado", target = "active"),
  })
  Category toCategory(Categoria categoria);

  @InheritInverseConfiguration 
  @Mapping(target = "productos", ignore = true)
  Categoria toCategoria(Category category);
}