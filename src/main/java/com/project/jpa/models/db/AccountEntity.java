package com.project.jpa.models.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

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

  @Column(name = "branch_address")
  private String branchAddress;

  @Column(name = "ifsc_code")
  private String ifscCode;

  @Column(name = "micr_code")
  private String micrCode;

  @ManyToOne(optional = false, fetch = FetchType.EAGER)
  @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
  private CustomerEntity customerEntity;
}
