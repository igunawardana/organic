package com.organics.ms.profile.controller;

import com.organics.ms.profile.exception.ProductNotFoundException;
import com.organics.ms.profile.model.Product;
import com.organics.ms.profile.service.IProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

  private final IProductService service;

  private static final Logger log = LogManager.getLogger(ProductController.class);

  public ProductController(IProductService service) {
    this.service = service;
  }

  @GetMapping(path = "/{productId}")
  public @ResponseBody
  ResponseEntity<Product> getProduct(@PathVariable("productId") int productId) {
    log.debug("Getting the product for id: " + productId);
    try {
      return new ResponseEntity(service.getProduct(productId), HttpStatus.OK);
    } catch (ProductNotFoundException e) {
      log.error("Error in retrieving the product. ", e);
      return new ResponseEntity("Error in retrieving the product.", HttpStatus.BAD_REQUEST);
    } catch (Exception e) {
      log.error("Error in retrieving the product. ", e);
      return new ResponseEntity("Error in retrieving the product.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping(path = "/")
  public @ResponseBody
  ResponseEntity<Iterable<Product>> getAllProducts() {
    log.debug("Getting all the products");
    try {
      return new ResponseEntity(service.getAllProducts(), HttpStatus.OK);
    } catch (Exception e) {
      log.error("Error in retrieving the product list. ", e);
      return new ResponseEntity("Error in retrieving the product list.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping(path = "/add")
  public @ResponseBody
  ResponseEntity<Product> addNewProduct(@RequestBody Product product) {
    log.debug("Adding new product: " + product.getName());
    try {
      return new ResponseEntity<Product>(service.save(product), HttpStatus.CREATED);
    } catch (Exception e) {
      log.error("Error in creating the product. ", e);
      return new ResponseEntity("Error in creating the product.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping(path = "/")
  public @ResponseBody
  ResponseEntity<Product> updateProduct(@RequestBody Product product) {
    try {
      log.debug("Updating the product for productId: " + product.getId());
      return new ResponseEntity<Product>(service.update(product), HttpStatus.OK);
    } catch (Exception e) {
      log.error("Error in updating the product. ", e);
      return new ResponseEntity("Error in updating the product.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping(path = "/{productId}")
  public @ResponseBody
  ResponseEntity deleteProduct(@PathVariable("productId") int productId) {
    log.debug("Deleting the product for id: " + productId);
    try {
      service.remove(productId);
      return new ResponseEntity("product Deleted Successfully.", HttpStatus.OK);
    } catch (Exception e) {
      log.error("Error in deleting the product. ", e);
      return new ResponseEntity("Error in deleting the product.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
