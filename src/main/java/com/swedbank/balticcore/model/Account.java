package com.swedbank.balticcore.model;

import lombok.Data;

@Data
public class Account {
  private final String accountId;
  private String IBAN;
  private final String status;
  private final String ownerId;
}
