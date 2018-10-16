package com.example.requestservice.rest;

import com.example.requestservice.domain.dto.RequestDto;
import com.example.requestservice.domain.dto.SomeRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class RequestControllerTest {

    @Autowired
    private WebTestClient client;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Queue queue;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void processRequest() throws Exception {
        SomeRequestDto dto = new SomeRequestDto(UUID.randomUUID().toString(), "test", 1);

        client.post().uri("/request")
                .syncBody(dto)
                .exchange()
                .expectStatus().is2xxSuccessful();
    }
}