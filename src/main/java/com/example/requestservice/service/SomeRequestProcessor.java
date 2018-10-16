package com.example.requestservice.service;

import com.example.requestservice.domain.dto.SomeRequestDto;
import com.example.requestservice.domain.entry.SomeRequestEntry;
import com.example.requestservice.domain.mapper.entry.EntryMapper;
import com.example.requestservice.repository.RequestRepository;
import org.springframework.stereotype.Service;

@Service
public class SomeRequestProcessor extends AbstractRequestProcessor<SomeRequestDto, SomeRequestEntry>{

    public SomeRequestProcessor(EntryMapper<SomeRequestDto, SomeRequestEntry> entryMapper, RequestRepository repository) {
        super(entryMapper, repository);
    }

}
