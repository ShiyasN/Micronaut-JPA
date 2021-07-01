package com.project.jpa.repository;

import com.project.jpa.models.db.CustomerEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

  List<CustomerEntity> findAll();

  List<CustomerEntity> findByName(String name);

  //    @Query(value = "select accounts.account_type from accounts inner join customers on
  // accounts.customer_id = customers.customer_id where accounts.customer_id = :customerId",
  // nativeQuery = true)
  //    List<AccountEntity> findBy

}
