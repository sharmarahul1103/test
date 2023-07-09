package com.Order.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.Order.Entity.Order;
import com.Order.Entity.OrderLineItems;
import com.Order.Repo.OrderRepo;
import com.Order.dto.OrderLineItemsDto;
import com.Order.dto.OrderRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService {
	
	private final OrderRepo orderRepo;
	
	public void placeOrder(OrderRequest orderRequest)
	{
		Order order=new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems>  orderLineItems=orderRequest.getOrderLineItemsDto().stream()
		.map(orderLinesItemsDto  -> mapToDto(orderLinesItemsDto))
		.toList();
		
        order.setOrderLineItemsList(orderLineItems);
        orderRepo.save(order);
		
	}
	
	
	private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto)
	{
		OrderLineItems orderLineItems=new OrderLineItems();
		orderLineItems.setPrice(orderLineItemsDto.getPrice());
		orderLineItems.setQty(orderLineItemsDto.getQty());
		orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
	
	   return orderLineItems;
	}

}
