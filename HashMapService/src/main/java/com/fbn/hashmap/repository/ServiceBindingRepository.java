package com.fbn.hashmap.repository;

import com.fbn.hashmap.model.ServiceInstanceBinding;
import org.springframework.data.repository.CrudRepository;

public interface ServiceBindingRepository extends CrudRepository<ServiceInstanceBinding,String> {
}
