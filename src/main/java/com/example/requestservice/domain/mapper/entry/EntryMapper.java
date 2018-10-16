package com.example.requestservice.domain.mapper.entry;

import com.example.requestservice.domain.dto.RequestDto;
import com.example.requestservice.domain.entry.RequestEntry;

public interface EntryMapper<D extends RequestDto, E extends RequestEntry> {
    E makeEntry(D dto);

    default E setId(D dto, E entry){
        entry.setId(dto.getId());
        return entry;
    }
}
