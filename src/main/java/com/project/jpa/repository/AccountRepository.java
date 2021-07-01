package com.project.jpa.repository;

import com.project.jpa.models.db.CustomerEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface AccountRepository extends JpaRepository<CustomerEntity, Long> {


}
