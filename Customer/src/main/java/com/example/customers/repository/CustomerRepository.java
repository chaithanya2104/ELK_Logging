package com.example.customers.repository;

import com.example.customers.model.Customers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customers,Long> {
    //CrudRepositories includes save, delete, find customer entities
    //Spring JPA lets you define other query methods by declaring the method signature
    //eg: findByLastName(), findByFirstName(),findByEmail()

    //    Customer findByEmail(String Email);
    List<Customers> findAll();
    //    @Override
    Optional<Customers> findByEmail(String email);
}
