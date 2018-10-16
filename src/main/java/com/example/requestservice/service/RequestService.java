package com.example.requestservice.service;

import com.example.requestservice.domain.dto.RequestDto;
import com.example.requestservice.domain.mapper.dto.RequestDtoMapper;
import com.example.requestservice.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class RequestService {

    private final RabbitService rabbitService;
    private final RequestRepository repository;
    private final RequestDtoMapper requestDtoMapper;


    public Mono<String> sendToQueue(RequestDto dto){
        if (dto.getId() == null){
            dto.setId(UUID.randomUUID().toString());
        }
        return Mono.fromRunnable(()->rabbitService.sendToQueue(dto))
                .thenReturn(dto.getId());
    }

    public Mono<RequestDto> getResult(String id) {
        return repository.findById(id)
                .map(requestDtoMapper::makeDto);
    }
}
