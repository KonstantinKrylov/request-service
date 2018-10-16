package com.example.requestservice.domain.mapper.dto;

import com.example.requestservice.domain.dto.SomeRequestDto;
import com.example.requestservice.domain.entry.SomeRequestEntry;
import org.springframework.stereotype.Service;

@Service
public class SomeRequestDtoMapper implements DtoMapper<SomeRequestEntry, SomeRequestDto> {

    @Override
    public SomeRequestDto makeDto(SomeRequestEntry entry) {
        return null;
    }
}
