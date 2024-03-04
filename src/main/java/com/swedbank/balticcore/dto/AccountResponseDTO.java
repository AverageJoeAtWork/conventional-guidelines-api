package com.swedbank.balticcore.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountResponseDTO {
  private String accountId;
  private String IBAN;
  private String status;
  private BigDecimal balance;
  private String customerName;
  private String customerEmail;
}
