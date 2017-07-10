package org.activemq;

import java.util.Date;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableScheduling
@RabbitListener(queues = "foo")
public class App {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	static int count = 0;

	@Scheduled(fixedDelay = 3000) // 3s执行1次此方法;
	public void send() {
		rabbitTemplate.convertAndSend("foo", "zhang:"+count);
		count ++;
	}

	@Bean
	public Queue fooQueue() {
		return new Queue("foo");
	}

	// 接收到消息处理.
	@RabbitHandler
	public void onMessage(@Payload String foo) {
		System.out.println(" >>> " + new Date() + ": " + foo);
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
