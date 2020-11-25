package com.organics.ms.profile.repository;

import com.organics.ms.profile.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
//  Product update(Product product);TODO
}
