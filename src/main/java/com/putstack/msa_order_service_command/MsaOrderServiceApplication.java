package com.putstack.msa_order_service_command;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class MsaOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaOrderServiceApplication.class, args);
	}
    
}
