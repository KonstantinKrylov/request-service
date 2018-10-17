package com.example.requestservice.rest;

import com.example.requestservice.domain.dto.RequestDto;
import com.example.requestservice.domain.dto.SomeRequestDto;
import com.example.requestservice.service.RequestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebFluxTest
@RunWith(SpringRunner.class)
public class RequestControllerTest {

    @Autowired
    private WebTestClient client;

    @MockBean
    private RequestService requestService;

    @Test
    public void processRequest() throws Exception {
        SomeRequestDto dto = new SomeRequestDto(UUID.randomUUID().toString(), "test", 1);
        when(requestService.sendToQueue(any(RequestDto.class))).thenReturn(Mono.just(dto.getId()));

        client.post().uri("/request")
                .syncBody(dto)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody()
                .jsonPath("$").isEqualTo(dto.getId());


    }
}