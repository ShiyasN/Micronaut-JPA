package com.project.jpa.repository;

import com.project.jpa.models.db.AccountEntity;
import com.project.jpa.models.db.CustomerEntity;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

  Optional<AccountEntity> findByAccountId(Long accountId);

  @Query(
      value = "select * from accounts  where accounts.account_id = :accountId",
      nativeQuery = true)
  Optional<AccountEntity> findByAccountIdCustom(Long accountId);

  @Query(
      value =
          "select * from accounts inner join customers on customers.customer_id = accounts.customer_id where accounts.customer_id = :customerId",
      nativeQuery = true)
  List<AccountEntity> findAccountsForCustomerId(Long customerId);

  List<AccountEntity> findByCustomerEntity(CustomerEntity customerEntity);
}
