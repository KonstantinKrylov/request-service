package com.example.requestservice.service;

import com.example.requestservice.domain.dto.SomeRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestServiceTest {

    @Autowired
    private RequestService requestService;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private Queue queue;

    @Test
    public void process() throws Exception {

        SomeRequestDto dto = new SomeRequestDto(UUID.randomUUID().toString(), "test", 1);
        String requestId = requestService.sendToQueue(dto).block();
        assertEquals(dto.getId(), requestId);

    }
}
