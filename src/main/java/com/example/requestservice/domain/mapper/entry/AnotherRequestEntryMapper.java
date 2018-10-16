package com.example.requestservice.domain.mapper.entry;

import com.example.requestservice.domain.dto.AnotherRequestDto;
import com.example.requestservice.domain.entry.AnotherRequestEntry;
import org.springframework.stereotype.Service;

@Service
public class AnotherRequestEntryMapper implements EntryMapper<AnotherRequestDto, AnotherRequestEntry>{

    @Override
    public AnotherRequestEntry makeEntry(AnotherRequestDto dto) {
        AnotherRequestEntry entry = new AnotherRequestEntry();
        entry.setAnotherIntegerField(dto.getAnotherIntegerField());
        entry.setAnotherStringField(dto.getAnotherStringField());
        setId(dto, entry);
        return entry;
    }
}
