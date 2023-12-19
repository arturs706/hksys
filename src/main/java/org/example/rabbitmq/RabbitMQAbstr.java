package org.example.rabbitmq;

// Abstraction
public abstract class RabbitMQAbstr {
    protected String CLOUDAMQP_URL;
    protected String QUEUENAME;

    public RabbitMQAbstr(String CLOUDAMQP_URL, String QUEUENAME) {
        this.CLOUDAMQP_URL = CLOUDAMQP_URL;
        this.QUEUENAME = QUEUENAME;
    }

    public abstract void getMessage() throws Exception;
    public abstract void sendMessage(String message) throws Exception;
}