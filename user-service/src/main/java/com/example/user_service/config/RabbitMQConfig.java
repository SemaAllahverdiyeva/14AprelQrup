package com.example.user_service.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig {

    @Bean
    public TopicExchange computerExchange() {
        return new TopicExchange("computer.exchange");
    }

    @Bean
    public Queue computerCreatedQueue() {
        return new Queue("computer.created.queue", true);
    }

    @Bean
    public Binding computerBinding(
            Queue computerCreatedQueue,
            TopicExchange computerExchange) {

        return BindingBuilder
                .bind(computerCreatedQueue)
                .to(computerExchange)
                .with("computer.created");
    }
}