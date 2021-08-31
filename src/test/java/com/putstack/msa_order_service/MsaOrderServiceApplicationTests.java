package com.putstack.msa_order_service;

import com.putstack.msa_order_service.dto.CancelDTO;
import com.putstack.msa_order_service.dto.OrderDTO;
import com.putstack.msa_order_service.service.OrderCommandService;

// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

import lombok.RequiredArgsConstructor;

// @SpringBootTest
@RequiredArgsConstructor
class MsaOrderServiceApplicationTests {
    private final OrderCommandService orderService;

	// @Test
	void contextLoads() {
	}

	// @Test
	// public void createOrderTest () {
	// 	OrderDTO orderDTO = new OrderDTO("userId", "productId", 4, 1000);
	// 	orderService.createOrder(orderDTO);
	// }

	// @Test
	// public void cancelOrder () {
	// 	CancelDTO cancelDTO = new CancelDTO("testID");
	// 	orderService.cancelOrder(cancelDTO);
	// }

}
