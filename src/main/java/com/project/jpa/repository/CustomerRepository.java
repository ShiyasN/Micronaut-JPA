package com.project.jpa.repository;

import com.project.jpa.models.db.CustomerEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    List<CustomerEntity> findAll();

    Optional<CustomerEntity> findByName(String name);

//    @Query(
//            "select accounts.account_type from accounts inner join customers on accounts.customer_id = customers.customer_id where accounts.customer_id = :customerId")
//    @Join(value = "accounts")n
//    List<String> findAllAccountsForACustomer(Long customerId);

    Optional<CustomerEntity> findByCustomerId(Long customerId);
}
