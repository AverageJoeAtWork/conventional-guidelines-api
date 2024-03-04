package com.swedbank.balticcore.repository;

import com.swedbank.balticcore.exception.AccountOperationException;
import com.swedbank.balticcore.model.Account;
import com.swedbank.balticcore.repository.dao.AccountDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class AccountRepository {

  private final AccountDAO accountDAO;

  public Account getAccount(String id) {
    return accountDAO.getAccount(id).orElseThrow(() -> new AccountOperationException("Could not find account " + id));
  }

  public List<Account> getAccounts() {
    return accountDAO.getAccounts();
  }

  public int addAccount(Account account) {
    return accountDAO.addAccount(account);
  }

}
