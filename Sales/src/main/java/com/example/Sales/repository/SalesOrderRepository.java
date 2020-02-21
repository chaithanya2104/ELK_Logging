package com.example.Sales.repository;

import com.example.Sales.model.SalesOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalesOrderRepository extends CrudRepository<SalesOrder,Long> {

    List<SalesOrder> findAll();
    @Override
    Optional<SalesOrder> findById(Long id);
    List<SalesOrder> findByEmail(String email);
}
