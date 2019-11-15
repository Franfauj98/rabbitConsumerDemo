package com.rabbit.consumer.rabbitconsumerdemo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class RabbitConsumerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitConsumerDemoApplication.class, args);
	}

}
