package com.project.jpa.models.db;

import io.micronaut.core.annotation.Nullable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

  //    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
  //    private List<AccountEntity> accountEntityList;

  public static CustomerEntity buildCustomerEntityFromCustomer(Customer customer) {
    return CustomerEntity.builder()
        .customerId(customer.getCustomerId())
        .name(customer.getName())
        .phoneNo(customer.getPhoneNo())
        .build();
  }
}
