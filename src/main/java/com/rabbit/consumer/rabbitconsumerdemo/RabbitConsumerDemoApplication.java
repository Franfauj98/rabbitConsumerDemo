package com.rabbit.consumer.rabbitconsumerdemo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EnableRabbit
@SpringBootApplication
@EntityScan(basePackages = {"com.rabbit.producer.rabbitconsumerdemo"})
public class RabbitConsumerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitConsumerDemoApplication.class, args);
	}

}
