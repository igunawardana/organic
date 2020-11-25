package com.organics.ms.profile.service;

import com.organics.ms.profile.exception.ProductNotFoundException;
import com.organics.ms.profile.model.Product;

public interface IProductService {

  Product getProduct(int productId) throws ProductNotFoundException;

  Iterable<Product> getAllProducts();

  Product save(Product product);

  Product update(Product product) throws ProductNotFoundException;

  void remove(int productId) throws ProductNotFoundException;

}
