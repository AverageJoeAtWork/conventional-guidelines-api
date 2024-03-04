package com.swedbank.balticcore.service;

import com.swedbank.balticcore.dto.AddAccountRequestDTO;
import com.swedbank.balticcore.dto.GetAccountRequestDTO;
import com.swedbank.balticcore.dto.AccountResponseDTO;

import java.util.List;

public interface AccountService {
  AccountResponseDTO getAccount(GetAccountRequestDTO accountRequestDTO);

  int addAcoount(AddAccountRequestDTO addAccountRequestDTO);

  List<AccountResponseDTO> getAccounts(String format);

}
