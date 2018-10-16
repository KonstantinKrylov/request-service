package com.example.requestservice.domain.mapper.dto;

import com.example.requestservice.domain.dto.AnotherRequestDto;
import com.example.requestservice.domain.dto.RequestDto;
import com.example.requestservice.domain.dto.SomeRequestDto;
import com.example.requestservice.domain.entry.AnotherRequestEntry;
import com.example.requestservice.domain.entry.RequestEntry;
import com.example.requestservice.domain.entry.SomeRequestEntry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestDtoMapper {

    private final SomeRequestDtoMapper someRequestMapper;
    private final AnotherRequestDtoMapper anotherRequestMapper;

    public SomeRequestDto makeDto(SomeRequestEntry entry){
        return someRequestMapper.makeDto(entry);
    }

    public AnotherRequestDto makeDto(AnotherRequestEntry entry){
        return anotherRequestMapper.makeDto(entry);
    }

    public RequestDto makeDto(RequestEntry entry){
        throw new UnsupportedOperationException("Couldn't map entry to dto");
    }


}
