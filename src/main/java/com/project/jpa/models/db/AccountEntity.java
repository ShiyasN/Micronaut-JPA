package com.project.jpa.models.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity implements Serializable {
  @Id
  @Column(name="account_id")
  @NotNull
  private Long accountId;

  @Column(name="account_type")
  private String accountType;

  @Column(name="branch")
  private String branch;

  @JoinColumn(name = "customers", referencedColumnName = "customer_id")
  @ManyToOne
  private CustomerEntity customerEntity;
}
