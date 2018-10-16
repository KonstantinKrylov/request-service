package com.example.requestservice.service;

import com.example.requestservice.domain.dto.AnotherRequestDto;
import com.example.requestservice.domain.entry.AnotherRequestEntry;
import com.example.requestservice.domain.mapper.entry.EntryMapper;
import com.example.requestservice.repository.RequestRepository;
import org.springframework.stereotype.Service;

@Service
public class AnotherRequestProcessor extends AbstractRequestProcessor<AnotherRequestDto, AnotherRequestEntry> {

    public AnotherRequestProcessor(EntryMapper<AnotherRequestDto, AnotherRequestEntry> entryMapper, RequestRepository repository) {
        super(entryMapper, repository);
    }
}
