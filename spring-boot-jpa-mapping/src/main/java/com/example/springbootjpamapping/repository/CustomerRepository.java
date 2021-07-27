package com.example.springbootjpamapping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springbootjpamapping.dto.OrderResponse;
import com.example.springbootjpamapping.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query("SELECT new  com.example.springbootjpamapping.dto.OrderResponse(c.name, p.productName) From Customer c JOIN c.products p")
	public List<OrderResponse> getJoinInformation();
}
