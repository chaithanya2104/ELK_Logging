package com.example.Item.repository;

import com.example.Item.model.Items;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<Items,Long> {
    List<Items> findAll();
    Optional<Items> findByName(String name);
}