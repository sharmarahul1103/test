package com.Order.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Order.Service.OrderService;
import com.Order.dto.OrderRequest;

@RestController
@RequestMapping("orderapp")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/placeOrder")
	@ResponseStatus(value = HttpStatus.OK)
	public String placeOrder(@RequestBody OrderRequest orderRequest)
	{
		
		orderService.placeOrder(orderRequest);
		return "Order Placed successfully";
	}

}
