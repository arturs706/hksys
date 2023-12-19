package org.example.rabbitmq;

// Implementor
public interface RabbitMQImpl {
    void consumeMessages(String queueName, String CLOUDAMQP_URL) throws Exception;
    void publishMessage(String queueName, String CLOUDAMQP_URL, String message) throws Exception;
}
