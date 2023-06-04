package com.in5minutes.springbootjpaend2end.repo;

import com.in5minutes.springbootjpaend2end.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
