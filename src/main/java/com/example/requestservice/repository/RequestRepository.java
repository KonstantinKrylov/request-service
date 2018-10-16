package com.example.requestservice.repository;

import com.example.requestservice.domain.entry.RequestEntry;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RequestRepository extends ReactiveMongoRepository<RequestEntry, String> {
}
