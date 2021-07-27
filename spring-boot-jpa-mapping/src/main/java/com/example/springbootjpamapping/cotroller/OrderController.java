package com.example.springbootjpamapping.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootjpamapping.dto.OrderRequest;
import com.example.springbootjpamapping.dto.OrderResponse;
import com.example.springbootjpamapping.entity.Customer;
import com.example.springbootjpamapping.repository.CustomerRepository;
import com.example.springbootjpamapping.repository.ProductRepository;

@RestController
public class OrderController {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/placeOrder")
	public Customer placeOrder(@RequestBody OrderRequest request) {
		return customerRepository.save(request.getCustomer());
	}
	@GetMapping("/findAllOrders")
	public List<Customer> findAllOrders(){
		return customerRepository.findAll();
	}
	
	@GetMapping("/getInfo")
	public List<OrderResponse> getJoinInformation(){
		return customerRepository.getJoinInformation();
	}

}
