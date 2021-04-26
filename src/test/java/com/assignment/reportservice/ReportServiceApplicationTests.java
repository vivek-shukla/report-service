package com.assignment.reportservice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.amqp.rabbit.test.RabbitListenerTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

import com.assignment.reportservice.consumer.AccountStateChangeListener;
import com.assignment.reportservice.util.Constants;
import com.assignment.reportservice.util.TestUtil;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RabbitListenerTest
class ReportServiceApplicationTests {

	@LocalServerPort
	private int serverPort;
	
	@Autowired
	private RabbitTemplate template;
	
	@Autowired
	private RabbitListenerEndpointRegistry rabbitListenerEndpointRegistry;
	
	@Test
	public void listenerTest() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(10);
		template.convertAndSend(Constants.TOPIC_EXCHANGE, Constants.ROUTING_KEY, TestUtil.getAccountStateChange());
		template.convertAndSend(Constants.TOPIC_EXCHANGE, Constants.ROUTING_KEY, TestUtil.getAccountStateChange());
		latch.await(10L, TimeUnit.SECONDS);
		rabbitListenerEndpointRegistry.getListenerContainer(
	            Constants.ACCOUNT_STATE_CHANGE_LISTENER
	    ).start();
	}
}
