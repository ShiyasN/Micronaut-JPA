package com.project.jpa.models.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
  private Long customerId;

  private String name;

  private String phoneNo;

  public Customer(CustomerEntity customerEntity) {
    this.customerId = customerEntity.getCustomerId();
    this.name = customerEntity.getName();
    this.phoneNo = customerEntity.getPhoneNo();
  }
}
