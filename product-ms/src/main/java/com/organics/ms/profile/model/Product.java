package com.organics.ms.profile.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "PRODUCT_SEQ", sequenceName = "product_sequence")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "PRODUCT_SEQ")
  private Integer id;
  private String name;
  private String description;
  private ProductCategory productCategory;

  public Product() {
  }

  public Product(String name, String description, ProductCategory productCategory) {
    this.name = name;
    this.description = description;
    this.productCategory = productCategory;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductCategory getProductCategory() {
    return productCategory;
  }

  public void setProductCategory(ProductCategory productCategory) {
    this.productCategory = productCategory;
  }
}
