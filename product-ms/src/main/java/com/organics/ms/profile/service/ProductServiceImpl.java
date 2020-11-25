package com.organics.ms.profile.service;

import com.organics.ms.profile.exception.ProductNotFoundException;
import com.organics.ms.profile.model.Product;
import com.organics.ms.profile.repository.IProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

  private final IProductRepository IProductRepository;

  public ProductServiceImpl(IProductRepository iProductRepository) {
    this.IProductRepository = iProductRepository;
  }

  @Override
  public Product getProduct(int productId) throws ProductNotFoundException {
    return IProductRepository.findById(productId)
            .orElseThrow(() -> new ProductNotFoundException("No matching user for product id = " + productId));
  }

  @Override
  public Iterable<Product> getAllProducts() {
    return IProductRepository.findAll();
  }

  @Override
  public Product save(Product product) {
    return IProductRepository.save(product);
  }

  @Override
  public void remove(int productId) throws ProductNotFoundException {
    try {
      IProductRepository.deleteById(productId);
    } catch (Exception e) {
      throw new ProductNotFoundException("Error in removing product with productId = " + productId, e);
    }
  }

  @Override
  public Product update(Product user) throws ProductNotFoundException {
    return IProductRepository.save(user);
    //TODO use update implementation
    //TODO test product not found exception
  }
}
