package com.example.requestservice;

import com.example.requestservice.domain.dto.SomeRequestDto;
import com.example.requestservice.repository.RequestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RequestServiceApplicationTests {

    @Autowired
    private WebTestClient client;

    @Autowired
    private RequestRepository repository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void sendSomeRequest() throws Exception {

        SomeRequestDto dto = new SomeRequestDto(UUID.randomUUID().toString(), "test", 1);

        String result = client.post().uri("/request")
                .syncBody(dto)
                .exchange()
                .expectStatus().isOk()
                .returnResult(String.class)
                .getResponseBody()
                .blockLast();

        assertEquals(dto.getId(), result);
        TimeUnit.SECONDS.sleep(2);

        client.get().uri("/request/{id}", result)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("id").isEqualTo(result)
                .jsonPath("someStringField").isEqualTo(dto.getSomeStringField())
                .jsonPath("someIntegerField").isEqualTo(dto.getSomeIntegerField());
    }
}
