package com.project.jpa.models.db;

import io.micronaut.core.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerEntity implements Serializable {

  @Id
  @Column(name = "customer_id")
  @NotNull
  private Long customerId;

  @Column(name = "customer_name")
  private String name;

  @Nullable
  @Column(name = "phone_number")
  private String phoneNo;

  @Nullable
  @Column(name = "city")
  private String city;

  @Nullable
  @Column(name = "address")
  private String address;

  @Nullable
  @Column(name = "email")
  private String email;


  public static CustomerEntity buildCustomerEntityFromCustomer(Customer customer) {
    return CustomerEntity.builder()
        .customerId(customer.getCustomerId())
        .name(customer.getName())
        .phoneNo(customer.getPhoneNo())
        .city(customer.getCity())
        .email(customer.getEmail())
        .address(customer.getAddress())
        .build();
  }
}
