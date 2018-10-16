package com.example.requestservice.domain.dto;


import com.example.requestservice.domain.entry.AnotherRequestEntry;
import com.example.requestservice.domain.entry.SomeRequestEntry;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SomeRequestEntry.class, name = "someRequest"),
        @JsonSubTypes.Type(value = AnotherRequestEntry.class, name = "anotherRequest")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
    private String id;
}
