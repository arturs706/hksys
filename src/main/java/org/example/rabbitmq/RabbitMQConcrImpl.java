package org.example.rabbitmq;

import com.rabbitmq.client.*;
import java.io.IOException;

// Concrete Implementor
public class RabbitMQConcrImpl implements RabbitMQImpl {
    private ConnectionFactory factory;
    public RabbitMQConcrImpl() {
        this.factory = new ConnectionFactory();
    }

    @Override
    public void consumeMessages(String queueName, String CLOUDAMQP_URL) throws Exception {
        try {
            factory.setUri(CLOUDAMQP_URL);
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            DeliverCallback deliverCallback = (s, delivery) -> {
                System.out.println("Message " + new String(delivery.getBody(), "UTF-8") + " received");
            };
            CancelCallback cancelCallback = System.out::println;
            channel.basicConsume(queueName, true, deliverCallback, cancelCallback);
        } catch (IOException e) {
            throw new RabbitMQException("Failed to publish message", e);
        }

    }

    @Override
    public void publishMessage(String queueName, String CLOUDAMQP_URL, String message) throws Exception {
        try {
            factory.setUri(CLOUDAMQP_URL);
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            System.out.println("Message " + message + " sent");
            channel.basicPublish("", queueName, null, message.getBytes());
            channel.close();
        } catch (IOException e) {
            throw new RabbitMQException("Failed to publish message", e);
        }
    }
}
