package com.swedbank.balticcore.repository.dao;

import com.swedbank.balticcore.model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

//Here locked all specifics about actual datastore type DB, inMemory DB, in Memory storage, File storage, whatever ...

@Component
public class CustomerDAO {

  private final RestTemplate restTemplate;

  public CustomerDAO(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public Optional<Customer> getCustomer(String id) {
    return Optional.ofNullable(restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/" + id, Customer.class));
  }

}
