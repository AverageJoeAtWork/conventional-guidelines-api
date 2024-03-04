package com.swedbank.balticcore.service;

import com.swedbank.balticcore.model.Balance;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

// Service is called from other services so has no modifier (package friendly) and can not be
@Service
final class BalanceServiceImpl implements BalanceService {

  @Override
  public Optional<Balance> getBalance() {
    return Optional.of(new Balance(BigDecimal.ZERO));
  }
}
