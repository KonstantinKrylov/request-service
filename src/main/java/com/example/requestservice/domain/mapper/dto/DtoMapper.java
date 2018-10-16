package com.example.requestservice.domain.mapper.dto;

import com.example.requestservice.domain.dto.RequestDto;
import com.example.requestservice.domain.entry.RequestEntry;

public interface DtoMapper<E extends RequestEntry, D extends RequestDto>{
    D makeDto(E entry);
}
