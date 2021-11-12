package com.arshaa.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;

public class OrderService {
	
	 @Autowired
	    private OrderDao orderDao;

	    @GetMapping
	    public List<Order> fetchOrders() {
	        return orderDao.getOrders().stream().
	                sorted(Comparator.comparingLong(Order::getPrice)).collect(Collectors.toList());
	    }

	    public static void main(String[] args) {
	        SpringApplication.run(OrderService.class, args);
	    }

}
