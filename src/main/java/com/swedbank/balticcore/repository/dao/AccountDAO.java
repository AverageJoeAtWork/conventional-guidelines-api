package com.swedbank.balticcore.repository.dao;

import com.swedbank.balticcore.model.Account;
import org.springframework.stereotype.Component;

import java.util.*;

//Here locked all specifics about actual datastore type DB, inMemory DB, in Memory storage, File storage, whatever ...

@Component
public class AccountDAO {

  private final Map<Integer, Account> accountStore = new HashMap<>();

  //in case of DB, RowMapper can be used to do mapping from Db data structure to domain model

  // Optional here because datasource accountStore can spit out null when accountId is not found
  public Optional<Account> getAccount(String id) {
    Integer accountId = Integer.parseInt(id);
    return Optional.ofNullable(accountStore.get(accountId));
  }

  // no Optional since there are no use case when null can be returned from this method
  public List<Account> getAccounts() {
    return new ArrayList<>(accountStore.values());
  }

  public int addAccount(Account account) {
    Integer accountId = Integer.parseInt(account.getAccountId());
    accountStore.put(accountId, account);
    return accountId;
  }

}
