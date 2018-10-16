package com.example.requestservice.listener;

import com.example.requestservice.domain.dto.RequestDto;
import com.example.requestservice.service.RequestProcessFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestListener {

    private final RequestProcessFactory factory;

    public void listen(RequestDto dto) {
        factory.processRequest(dto);
    }

}
