package com.project.jpa.controller;

import com.project.jpa.models.db.Account;
import com.project.jpa.models.db.Customer;
import com.project.jpa.service.CustomerService;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller("/customer")
public class CustomerController {

  private final CustomerService customerService;

  @Inject
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @Get("/")
  public List<Customer> getCustomer() {
    return customerService.getCustomers();
  }

  @Get("/searchByName")
  public List<Customer> getCustomerByName(@QueryValue String name) {
    return customerService.getCustomerByName(name);
  }

  @Post("/")
  public Customer addCustomer(@Body Customer customer) {
    return customerService.addCustomer(customer);
  }

  @Get("/{customerId}/accounts")
  public List<Account> getAllAccountsForACustomer(@PathVariable Long customerId) {
    return customerService.getAccountsForACustomer(customerId);
  }

  @Get("/accounts/{accountId}")
  public List<Account> getAccountDetailsForACustomer(@PathVariable Long accountId) {
    return customerService.getAccountDetailsForACustomer(accountId);
  }

  @Get("/accounts/multiple/{accountId}")
  public List<Account> getMultipleAccountDetails(@PathVariable Long accountId) {
    return customerService.getMultipleAccountDetails(accountId);
  }
}
