package com.example.requestservice.service;

import com.example.requestservice.domain.dto.RequestDto;
import lombok.RequiredArgsConstructor;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RequestProcessFactory {

    private final List<AbstractRequestProcessor> processors;
    private Map<Class, AbstractRequestProcessor> processorMap;


    @PostConstruct
    void init(){
        processorMap = StreamEx.of(processors)
                .toMap(AbstractRequestProcessor::getDtoClass, processor -> processor);
    }

    public void processRequest(RequestDto dto) {
        Class<? extends RequestDto> dtoClass = dto.getClass();
        AbstractRequestProcessor processor = processorMap.get(dtoClass);
        processor.process(dto);
    }
}
