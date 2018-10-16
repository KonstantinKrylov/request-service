package com.example.requestservice.service;

import com.example.requestservice.domain.dto.RequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestProcessFactory {

    private final SomeRequestProcessor testRequest1Processor;
    private final AnotherRequestProcessor testRequest2Processor;


    public void processRequest(RequestDto dto) {


    }
}
