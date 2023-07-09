package com.Order.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Order.Entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer>{
	
	

}
