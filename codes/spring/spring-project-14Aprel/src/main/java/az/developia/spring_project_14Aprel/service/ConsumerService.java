package az.developia.spring_project_14Aprel.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @RabbitListener(queues = "test-queue")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}