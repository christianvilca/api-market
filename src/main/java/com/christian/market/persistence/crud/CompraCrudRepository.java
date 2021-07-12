package com.christian.market.persistence.crud;

import java.util.List;
import java.util.Optional;

import com.christian.market.persistence.entity.Compra;

import org.springframework.data.repository.CrudRepository;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {
  Optional<List<Compra>> findByIdCliente(String idCliente);
}
