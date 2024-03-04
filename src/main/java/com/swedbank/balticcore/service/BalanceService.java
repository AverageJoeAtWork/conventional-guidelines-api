package com.swedbank.balticcore.service;

import com.swedbank.balticcore.model.Balance;

import java.util.Optional;

//
interface BalanceService {
  Optional<Balance> getBalance();
}
