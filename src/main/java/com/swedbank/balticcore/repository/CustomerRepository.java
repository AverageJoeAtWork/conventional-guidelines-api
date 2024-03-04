package com.swedbank.balticcore.repository;

import com.swedbank.balticcore.exception.CustomerOperationException;
import com.swedbank.balticcore.model.Customer;
import com.swedbank.balticcore.repository.dao.CustomerDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CustomerRepository {

  private final CustomerDAO customerDAO;

  public Customer getCustomer(String id) {
    return customerDAO.getCustomer(id).orElseThrow(() -> new CustomerOperationException("Could not find customer " + id));
  }



}
