package com.swedbank.balticcore.mappers;

import com.swedbank.balticcore.dto.AccountResponseDTO;
import com.swedbank.balticcore.model.Account;

public final class AccountDtoMapper {

  private AccountDtoMapper() {}

  public static AccountResponseDTO mapToDto(Account account) {
// Create a new instance of AccountResponseLombokDTO
    AccountResponseDTO dto = new AccountResponseDTO();

    // Map values from account to dto fields
    dto.setAccountId(account.getAccountId());
    dto.setStatus(account.getStatus());
    dto.setIBAN("IBAN" + account.getAccountId());

    // Return the mapped dto instance
    return dto;
  }
}