package com.christian.market.persistence;

import java.util.List;
import java.util.Optional;

import com.christian.market.domain.Product;
import com.christian.market.domain.repository.ProductRepository;
import com.christian.market.persistence.crud.ProductoCrudRepository;
import com.christian.market.persistence.entity.Producto;
import com.christian.market.persistence.mapper.ProductMapper;

import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepository implements ProductRepository {
  private ProductoCrudRepository productoCrudRepository;
  private ProductMapper mapper;

  public List<Product> getAll() {
    List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
    return mapper.toProducts(productos);
  }

  @Override
  public Optional<List<Product>> getByCategory(int categoryId) {
    List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
    return Optional.of(mapper.toProducts(productos));
  }

  @Override
  public Optional<List<Product>> getScarseProducts(int quantity) {
    Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
    return productos.map(prods -> mapper.toProducts(prods));
  }

  @Override
  public Optional<Product> getProduct(int productId) {
    return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
  }

  public Optional<Producto> getProducto(int idProducto) {
    return productoCrudRepository.findById(idProducto);
  }

  @Override
  public Product save(Product product) {
    Producto producto = mapper.toProducto(product);
    return mapper.toProduct(productoCrudRepository.save(producto));
  }

  @Override
  public void delete(int productId) {
    productoCrudRepository.deleteById(productId);
  }
}
