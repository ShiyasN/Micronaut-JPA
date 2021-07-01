package com.project.jpa.models.db;


import io.micronaut.core.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerEntity implements Serializable {

    @Id
    @Column(name="customer_id")
    @NotNull
    private Long customerId;

    @Column(name="customer_name")
    private String name;

    @Nullable
    @Column(name="phone_number")
    private String phoneNo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customerEntity")
    @Valid
    //@JoinColumn(name = "accounts", referencedColumnName = "customer_id")
    private List<AccountEntity> accountEntityList;

    public static CustomerEntity buildCustomerEntityFromCustomer(Customer customer) {
        return CustomerEntity.builder().customerId(customer.getCustomerId()).name(customer.getName()).phoneNo(customer.getPhoneNo()).build();
    }

}
