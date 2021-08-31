package com.putstack.msa_order_service.repository;

import com.putstack.msa_order_service.entity.OrderEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String> {

}
