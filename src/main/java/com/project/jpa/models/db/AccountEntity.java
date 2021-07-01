package com.project.jpa.models.db;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity implements Serializable {
  @Id
  @Column(name = "account_id")
  @NotNull
  private Long accountId;

  @Column(name = "account_type")
  private String accountType;

  @Column(name = "branch")
  private String branch;

  @ManyToOne(optional = false, fetch = FetchType.EAGER)
  @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
  private CustomerEntity customerEntity;
}
