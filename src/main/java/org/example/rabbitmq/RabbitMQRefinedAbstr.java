package org.example.rabbitmq;

// Refined Abstraction
public class RabbitMQRefinedAbstr extends RabbitMQAbstr {
    private RabbitMQImpl implementor;

    public RabbitMQRefinedAbstr(RabbitMQImpl implementor, String CLOUDAMQP_URL, String QUEUENAME) {
        super(CLOUDAMQP_URL, QUEUENAME);
        this.implementor = implementor;
    }

    @Override
    public void getMessage() throws Exception {
        implementor.consumeMessages(QUEUENAME, CLOUDAMQP_URL);
    }

    @Override
    public void sendMessage(String message) throws Exception {
        implementor.publishMessage(QUEUENAME, CLOUDAMQP_URL, message);
    }
}
