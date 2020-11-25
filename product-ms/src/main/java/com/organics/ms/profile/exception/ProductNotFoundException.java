package com.organics.ms.profile.exception;

public class ProductNotFoundException extends RuntimeException {

  private static final String ERROR_CODE = "PRODUCT_SERVICE_ERR_001";

  public ProductNotFoundException() {
  }

  public ProductNotFoundException(String message) {
    super(message);
  }

  public ProductNotFoundException(Throwable cause) {
    super(cause);
  }

  public ProductNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public String getErrorCode() {
    return ERROR_CODE;
  }

}
