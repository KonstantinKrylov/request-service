package com.example.requestservice.rest;

import com.example.requestservice.domain.dto.RequestDto;
import com.example.requestservice.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/request")
@RequiredArgsConstructor
public class RequestController {

    private final RequestService service;

    @PostMapping
    public Mono<ServerResponse> processRequest(@RequestBody RequestDto dto){
        service.process(dto);
        return ServerResponse.ok().build();
    }
}
