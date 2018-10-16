package com.example.requestservice.service;

import com.example.requestservice.domain.dto.RequestDto;
import com.example.requestservice.domain.entry.RequestEntry;
import com.example.requestservice.domain.mapper.entry.EntryMapper;
import com.example.requestservice.repository.RequestRepository;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class AbstractRequestProcessor<D extends RequestDto, E extends RequestEntry> {

    private final EntryMapper<D, E> entryMapper;
    private final RequestRepository repository;
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();


    public void process(D dto){
        executor.schedule(()->processRequest(dto), 1, TimeUnit.SECONDS);
    }

    private void processRequest(D dto){
        E entry = entryMapper.makeEntry(dto);
        repository.insert(entry).subscribe();
    }

}
