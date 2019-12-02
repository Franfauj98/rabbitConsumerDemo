package com.rabbit.consumer.rabbitconsumerdemo.Service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BasicReceiver {

	@RabbitListener(queues = "rabbitExample.synchronous")
	public void receive1(String received) {
		try {
			Thread.sleep(20000);
			System.out.println("Received '" + received + " ' from rabbitExample.first, routingKey: first, date : " + LocalDateTime.now());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@RabbitListener(queues = "rabbitExample.asynchronous")
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
