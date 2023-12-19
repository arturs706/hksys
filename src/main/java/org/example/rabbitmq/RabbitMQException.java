package org.example.rabbitmq;

// Custom Exception
public class RabbitMQException extends Exception {
    public RabbitMQException(String message, Throwable cause) {
        super(message, cause);
    }
}