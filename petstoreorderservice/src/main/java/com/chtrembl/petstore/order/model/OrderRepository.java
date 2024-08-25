package com.chtrembl.petstore.order.model;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CosmosRepository<Order, String> {

}
