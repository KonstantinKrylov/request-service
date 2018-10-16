package com.example.requestservice.listener;

import com.example.requestservice.domain.dto.RequestDto;
import com.example.requestservice.service.RequestProcessFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RequestListener {

    private final RequestProcessFactory factory;

    @RabbitListener(queues = "${queue.name}")
    public void listen(RequestDto dto) {
        log.info("received dto: {}", dto);
        factory.processRequest(dto);
    }

}
