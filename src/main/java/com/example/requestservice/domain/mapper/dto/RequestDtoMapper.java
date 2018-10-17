package com.example.requestservice.domain.mapper.dto;

import com.example.requestservice.domain.dto.RequestDto;
import com.example.requestservice.domain.entry.RequestEntry;
import lombok.RequiredArgsConstructor;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RequestDtoMapper {

    private final List<DtoMapper> mappers;
    private Map<Class<RequestEntry>, DtoMapper> classDtoMapperMap;

    @PostConstruct
    void init(){
        classDtoMapperMap = StreamEx.of(mappers)
                .toMap(DtoMapper::getEntryClass, mapper -> mapper);
    }

    public RequestDto makeDto(RequestEntry entry){
        Class<? extends RequestEntry> aClass = entry.getClass();
        DtoMapper mapper = classDtoMapperMap.get(aClass);
        return mapper.makeDto(entry);
    }


}
