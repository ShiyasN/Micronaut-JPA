package com.project.jpa.controller;

import com.project.jpa.models.db.Customer;
import com.project.jpa.service.CustomerService;
import io.micronaut.http.HttpResponse;
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
    public List<Customer> getCustomer(){
        return customerService.getCustomers();
    }

    @Get("/searchByName/{name}")
    public HttpResponse getCustomerByName(@PathVariable String name){
         customerService.getCustomerByName(name);
         return HttpResponse.ok();
    }

    @Post("/")
    public Customer addCustomer(@Body Customer customer){
        return customerService.addCustomer(customer);
    }

    @Post("/bulkCreate")
    public String bulkCustomerCreate(){
        customerService.createMultipleCustomers();
        return "Done";
    }

    @Get("/{customerId}/accounts")
    public List<String> getAccountsForACustomer(@PathVariable Long customerId){
        return customerService.getAccountsForACustomer(customerId);
    }



}
