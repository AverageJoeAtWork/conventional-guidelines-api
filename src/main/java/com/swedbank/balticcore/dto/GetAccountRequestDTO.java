package com.swedbank.balticcore.dto;

import lombok.Value;


import java.time.LocalDate;

@Value
public class GetAccountRequestDTO {
  private final String id;
  private final String language;
  private final String format;
  private final LocalDate openedBefore;
}

