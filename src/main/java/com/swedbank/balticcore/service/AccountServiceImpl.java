package com.swedbank.balticcore.service;

import com.swedbank.balticcore.dto.AddAccountRequestDTO;
import com.swedbank.balticcore.dto.GetAccountRequestDTO;
import com.swedbank.balticcore.dto.AccountResponseDTO;
import com.swedbank.balticcore.model.Balance;
import com.swedbank.balticcore.model.Account;
import com.swedbank.balticcore.model.Customer;
import com.swedbank.balticcore.repository.AccountRepository;
import com.swedbank.balticcore.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

  private final BalanceService balanceService;
  private final AccountRepository accountRepository;
  private final CustomerRepository customerRepository;
  private final ModelMapper modelMapper;


  @Override
  public AccountResponseDTO getAccount(GetAccountRequestDTO accountRequestDTO) {

    if (accountRequestDTO.getOpenedBefore().isBefore(LocalDate.now())) {
      throw new RuntimeException("Oops ... too late");
    }

    Account account = accountRepository.getAccount(accountRequestDTO.getId());

    return prepareAccountResponseDTO(account);
  }

  @Override
  public int addAcoount(AddAccountRequestDTO addAccountRequestDTO) {
    int accntNumber = new Random().nextInt(100) + 1;
    Account account = new Account(String.valueOf(accntNumber), "active", addAccountRequestDTO.getCustomerId());
    return accountRepository.addAccount(account);
  }

  @Override
  public List<AccountResponseDTO> getAccounts(String format) {
    return accountRepository
        .getAccounts()
        .stream()
        .map(this::prepareAccountResponseDTO)
        .collect(Collectors.toList());
  }

  private AccountResponseDTO prepareAccountResponseDTO(Account account) {
    Balance balance = balanceService.getBalance().orElseThrow();
    Customer customer = customerRepository.getCustomer(account.getOwnerId());

    AccountResponseDTO accountResponseDTO = modelMapper.map(account, AccountResponseDTO.class);
    accountResponseDTO.setCustomerEmail(customer.getEmail());
    accountResponseDTO.setCustomerName(customer.getName());
    accountResponseDTO.setBalance(balance.isBalanceNegative() ? BigDecimal.ZERO : balance.getBalanceAmount());

    return accountResponseDTO;
  }

}