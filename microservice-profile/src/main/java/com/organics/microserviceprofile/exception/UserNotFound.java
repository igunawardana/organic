package com.organics.microserviceprofile.exception;

public class UserNotFound extends Exception {
  // TODO
  private static final String ERROR_CODE = "USR_ERR_001";

  private String message;

  public static String getErrorCode() {
    return ERROR_CODE;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public UserNotFound(String message) {
    setMessage(message);
  }

  @Override
  public String getMessage() {
    return this.message;
  }
}
