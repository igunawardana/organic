package com.organics.ms.profile.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import com.organics.ms.profile.model.ProductCategory;
import com.organics.ms.profile.model.Product;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IProductRepositoryTests {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private IProductRepository repository;

  @Test
  void testAddUser() throws Exception {
    this.entityManager.persist(new Product("TestProduct", "Organic food", ProductCategory.RAW));
    Optional<Product> product = this.repository.findById(1);
    assertThat(product.get().getName()).isEqualTo("TestProduct");
    assertThat(product.get().getDescription()).isEqualTo("Organic food");
  }
}