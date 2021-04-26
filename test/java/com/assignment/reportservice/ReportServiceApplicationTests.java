package com.assignment.reportservice;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

import com.assignment.reportservice.consumer.AccountStateChangeListener;
import com.assignment.reportservice.util.TestUtil;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ReportServiceApplicationTests {

	@LocalServerPort
	private int serverPort;
	
	@Autowired
	private AccountStateChangeListener accountStateChangeListener;
	
	@Autowired
	private RabbitListenerEndpointRegistry rabbitListenerEndpointRegistry;
	
	@Test
	public void listenerTest() throws InterruptedException {
		accountStateChangeListener.listener(TestUtil.getAccountStateChange());
		/*rabbitListenerEndpointRegistry.getListenerContainer(
	            Constants.ACCOUNT_STATE_CHANGE_LISTENER
	    ).start();
	    
	    */
	}
}
