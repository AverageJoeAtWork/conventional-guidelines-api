package com.swedbank.balticcore.exception;

public class CustomerOperationException extends RuntimeException {
  public CustomerOperationException(String message) {
    super(message);
  }
}
