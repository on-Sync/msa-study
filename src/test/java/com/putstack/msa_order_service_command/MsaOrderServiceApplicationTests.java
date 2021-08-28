package com.putstack.msa_order_service_command;

import com.putstack.msa_order_service_command.dto.CancelDTO;
import com.putstack.msa_order_service_command.dto.OrderDTO;
import com.putstack.msa_order_service_command.service.OrderService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.RequiredArgsConstructor;

@SpringBootTest
@RequiredArgsConstructor
class MsaOrderServiceApplicationTests {
    private final OrderService orderService;

	@Test
	void contextLoads() {
	}

	@Test
	public void createOrderTest () {
		OrderDTO orderDTO = new OrderDTO("userId", "productId", 4, 1000);
		orderService.createOrder(orderDTO);
	}

	// @Test
	// public void cancelOrder () {
	// 	CancelDTO cancelDTO = new CancelDTO("testID");
	// 	orderService.cancelOrder(cancelDTO);
	// }

}
