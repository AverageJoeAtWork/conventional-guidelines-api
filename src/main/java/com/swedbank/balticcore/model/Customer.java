package com.swedbank.balticcore.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Customer {
  int id;
  String name;
  String email;
}
