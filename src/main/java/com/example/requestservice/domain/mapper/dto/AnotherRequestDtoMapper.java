package com.example.requestservice.domain.mapper.dto;

import com.example.requestservice.domain.dto.AnotherRequestDto;
import com.example.requestservice.domain.entry.AnotherRequestEntry;
import org.springframework.stereotype.Service;

@Service
public class AnotherRequestDtoMapper implements DtoMapper<AnotherRequestEntry, AnotherRequestDto> {

    @Override
    public AnotherRequestDto makeDto(AnotherRequestEntry entry) {
        return null;
    }
}