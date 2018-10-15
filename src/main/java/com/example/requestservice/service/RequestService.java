package com.example.requestservice.service;

import com.example.requestservice.domain.dto.RequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final RabbitTemplate template;
    private final Queue queue;

    public void process(RequestDto dto) {
        template.convertAndSend(queue.getName(), dto);
    }
}