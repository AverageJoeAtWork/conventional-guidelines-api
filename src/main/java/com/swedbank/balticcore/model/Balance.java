package com.swedbank.balticcore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Balance {
  @NonNull private BigDecimal balanceAmount;

  public boolean isBalanceNegative() {
    return balanceAmount.compareTo(BigDecimal.ZERO) > 0;
  }
}
