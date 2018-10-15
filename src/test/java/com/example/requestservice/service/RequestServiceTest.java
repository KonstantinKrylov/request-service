package com.example.requestservice.service;

import com.example.requestservice.domain.dto.RequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RequestServiceTest {

    @Autowired
    private RequestService requestService;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private Queue queue;

    @Test
    public void process() throws Exception {

        RequestDto dto = new RequestDto(UUID.randomUUID().toString());
        requestService.process(dto);


    }
}
