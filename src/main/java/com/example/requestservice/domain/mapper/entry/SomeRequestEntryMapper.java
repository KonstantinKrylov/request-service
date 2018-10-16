package com.example.requestservice.domain.mapper.entry;

import com.example.requestservice.domain.dto.SomeRequestDto;
import com.example.requestservice.domain.entry.SomeRequestEntry;
import org.springframework.stereotype.Service;

@Service
public class SomeRequestEntryMapper implements EntryMapper<SomeRequestDto, SomeRequestEntry>{

    @Override
    public SomeRequestEntry makeEntry(SomeRequestDto dto) {
        return null;
    }
}
