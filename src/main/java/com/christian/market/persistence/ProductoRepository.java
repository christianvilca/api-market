package com.christian.market.persistence;

import java.util.List;

import com.christian.market.persistence.crud.ProductoCrudRepository;
import com.christian.market.persistence.entity.Producto;

public class ProductoRepository {
  private ProductoCrudRepository productoCrudRepository;

  public List<Producto> getAll() {
    return (List<Producto>)productoCrudRepository.findAll();
  }
}
