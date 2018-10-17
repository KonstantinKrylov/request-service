package com.example.requestservice.rest;

import com.example.requestservice.domain.dto.RequestDto;
import com.example.requestservice.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/request")
@RequiredArgsConstructor
public class RequestController {

    private final RequestService service;

    @PostMapping
    public Mono<String> processRequest(@RequestBody RequestDto dto) {
        return service.sendToQueue(dto);
    }

    @GetMapping("/{id}")
    public Mono<RequestDto> getResult(@PathVariable("id") String id) {
        return service.getResult(id);

    }
}
