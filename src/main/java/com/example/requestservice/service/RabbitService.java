package com.example.requestservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitService {
    private final RabbitTemplate template;
    private final Queue queue;

    public void sendToQueue(Object o){
        template.convertAndSend(queue.getName(), o);
    }
}
