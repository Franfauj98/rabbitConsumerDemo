package com.rabbit.consumer.rabbitconsumerdemo.Service;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BasicReceiver {
	private DirectExchange directExchange = new DirectExchange("rabbit.example.direct");
	private Queue queue = new Queue("rabbitExample.first");
	private Queue queue2 = new Queue("rabbitExample.second");

	@Bean
	public Binding bindingFirst() {
		return BindingBuilder.bind(queue)
				.to(directExchange)
				.with("first");
	}

	@Bean
	public Binding BindingSecond() {
		return BindingBuilder.bind(queue2)
				.to(directExchange)
				.with("second");
	}

	@RabbitListener(queues = "rabbitExample.first")
	public void receive1(String received) {
		try {
			Thread.sleep(20000);
			System.out.println("Received '" + received + " ' from rabbitExample.first, routingKey: first, date : " + LocalDateTime.now());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@RabbitListener(queues = "rabbitExample.second")
	public int receive2(String received) {
		try {
			System.out.println("Received '" + received + " ' from rabbitExample.second, routingKey: second, date : " + LocalDateTime.now());
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 42;
	}
}
