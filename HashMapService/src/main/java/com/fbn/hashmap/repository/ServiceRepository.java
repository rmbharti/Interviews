package com.fbn.hashmap.repository;

import com.fbn.hashmap.model.Service;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<Service, String> {
}
