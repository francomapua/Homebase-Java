package com.github.francomapua.amqp;

import java.io.IOException;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

/*
Note: Requires the following dependency
<dependency>
  <groupId>com.rabbitmq</groupId>
  <artifactId>amqp-client</artifactId>
  <version>5.6.0</version>
</dependency>
*/

public class ConnectionDemo {
    public void main() {
        ConnectionFactory factory = new ConnectionFactory();

        factory.setUsername("franco");
        factory.setPassword("Migosu824");
        factory.setVirtualHost("mcw");
        factory.setHost("10.30.13.7");
        factory.setPort(5672);

        // Or
        // factory.setUri("amqp://userName:password@hostName:portNumber/virtualHost");
        try {
            Connection conn = factory.newConnection();
            Channel channel = conn.createChannel();

            // Publish
            channel.basicPublish("task_exchange", "", null, "lolololol".getBytes());

            // Receive
            DeliverCallback deliverCallback = new DeliverCallback() {

                @Override
                public void handle(String consumerTag, Delivery delivery) throws IOException {
                    String message = new String(delivery.getBody(), "UTF-8");
                    System.out.println(message);
                }
            };

            /*
             * (consumerTag, delivery) -> { String message = new String(delivery.getBody(),
             * "UTF-8"); System.out.println(" [x] Received '" + message + "'"); };
             */
            channel.basicConsume("task_queue", true, deliverCallback, new CancelCallback() {

                @Override
                public void handle(String consumerTag) throws IOException {
                }
            });
        } catch (Exception ex) {
        }
    }

}