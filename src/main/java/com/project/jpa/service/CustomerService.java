package com.project.jpa.service;

import com.project.jpa.exceptions.ResourceConflictException;
import com.project.jpa.models.db.Account;
import com.project.jpa.models.db.AccountEntity;
import com.project.jpa.models.db.Customer;
import com.project.jpa.models.db.CustomerEntity;
import com.project.jpa.repository.AccountRepository;
import com.project.jpa.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

public class CustomerService {

  private final CustomerRepository customerRepository;
  private final AccountRepository accountRepository;

  @Inject
  public CustomerService(
      CustomerRepository customerRepository, AccountRepository accountRepository) {
    this.customerRepository = customerRepository;
    this.accountRepository = accountRepository;
  }

  public List<Customer> getCustomers() {

    Long startTime = System.currentTimeMillis();
    List<CustomerEntity> customerEntities = customerRepository.findAll();

    Long duration = System.currentTimeMillis() - startTime;
    System.out.println("duration" + duration);
    return customerEntities.stream().map(Customer::new).collect(Collectors.toList());
  }

  public Customer addCustomer(Customer customer) {
    if (customerRepository.findById(customer.getCustomerId()).isPresent()) {
      throw new ResourceConflictException("Customer is already present.");
    }
    CustomerEntity customerEntity = CustomerEntity.buildCustomerEntityFromCustomer(customer);
    customerRepository.save(customerEntity);
    return new Customer(customerEntity);
  }

  public List<Account> getAccountsForACustomer(Long customerId) {
    //        List<AccountEntity> accountEntities = accountRepository.findByCustomerEntity(
    //                CustomerEntity.builder().customerId(customerId).build());
    List<AccountEntity> accountEntities = accountRepository.findAccountsForCustomerId(customerId);
    return accountEntities.stream().map(Account::new).collect(Collectors.toList());
  }

  public List<Customer> getCustomerByName(String name) {
    List<CustomerEntity> customerEntities = customerRepository.findByName(name);
    return customerEntities.stream().map(Customer::new).collect(Collectors.toList());
  }

  public List<Account> getAccountDetailsForACustomer(Long accountId) {
    Optional<AccountEntity> accountEntities = accountRepository.findByAccountIdCustom(accountId);
    return accountEntities.stream().map(Account::new).collect(Collectors.toList());
  }
}
