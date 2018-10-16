package com.example.requestservice.service;

import com.example.requestservice.domain.dto.RequestDto;
import com.example.requestservice.domain.entry.RequestEntry;
import com.example.requestservice.domain.mapper.entry.EntryMapper;
import com.example.requestservice.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public abstract class AbstractRequestProcessor<D extends RequestDto, E extends RequestEntry> {

    private final EntryMapper<D, E> entryMapper;
    private final RequestRepository repository;


    @SneakyThrows
    public void process(D dto) {
        processRequest(dto);
    }

    private void processRequest(D dto) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        E entry = entryMapper.makeEntry(dto);
        repository.insert(entry).subscribe();
    }

    public abstract Class<D> getDtoClass();

}
