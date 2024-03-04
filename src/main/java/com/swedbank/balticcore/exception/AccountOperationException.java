package com.swedbank.balticcore.exception;

public class AccountOperationException extends RuntimeException {
  public AccountOperationException(String message) {
    super(message);
  }
}
