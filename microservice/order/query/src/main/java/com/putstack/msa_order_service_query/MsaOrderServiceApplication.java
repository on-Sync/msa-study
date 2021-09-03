package com.putstack.msa_order_service_query;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.putstack")
public class MsaOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaOrderServiceApplication.class, args);
	}

}
