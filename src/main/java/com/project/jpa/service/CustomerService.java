package com.project.jpa.service;

import com.project.jpa.exceptions.ResourceConflictException;
import com.project.jpa.models.db.Customer;
import com.project.jpa.models.db.CustomerEntity;
import com.project.jpa.repository.AccountRepository;
import com.project.jpa.repository.CustomerRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    @Inject
    public CustomerService(
            CustomerRepository customerRepository,
            AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }
    public List<Customer> getCustomers() {

        Long startTime = System.currentTimeMillis();
        List<CustomerEntity> customerEntities = customerRepository.findAll();

        Long duration = System.currentTimeMillis() - startTime;
        System.out.println("duration"+duration);
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

    public void createMultipleCustomers() {
        Long startTime = System.currentTimeMillis();
        IntStream.range(0, 10000).forEach(i -> {
             CustomerEntity customerEntity =
                     CustomerEntity.buildCustomerEntityFromCustomer(new Customer(i+12000L, "testing" + i, "12345" + i));
             customerRepository.save(customerEntity);
        });
        Long duration = System.currentTimeMillis() - startTime;
        System.out.println("duration for 1000 records ---- "+duration);
    }

    public List<String> getAccountsForACustomer(Long customerId){
        System.out.println("--------"+customerRepository.findByCustomerId(customerId));
        return List.of();
    }

    public void getCustomerByName(String name) {
        System.out.println(customerRepository.findByCustomerId(1L));
    }
}
