package com.example.repository;

import com.example.entity.Data;
import com.example.entity.DomainObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface DataRepository extends CrudRepository<Data,Long> {

    List<Data> findByDescription(String description);

}