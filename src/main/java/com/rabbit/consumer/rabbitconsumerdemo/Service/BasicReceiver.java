package com.rabbit.consumer.rabbitconsumerdemo.Service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BasicReceiver {

	@RabbitListener(queues = "rabbitExample.asynchronous")
	public void receiveAsynchronous(String received) {
		try {
			System.out.println("Start receiving asynchronously ");
			System.out.println("Received '" + received + " ' from rabbitExample.asynchronous, routingKey: asynchronous, date : "
					+ LocalDateTime.now());
			Thread.sleep(20000);
			System.out.println("Stop processing asynchronously ");
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}

	@RabbitListener(queues = "rabbitExample.synchronous")
	public int receiveSynchronous(String received) {
		try {
			System.out.println("Start receiving synchronously ");
			System.out.println("Received '" + received + " ' from rabbitExample.synchronous, routingKey: synchronous, date : "
					+ LocalDateTime.now());
			Thread.sleep(20000);
			System.out.println("Stop processing synchronously ");
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		return 42;
	}
}
