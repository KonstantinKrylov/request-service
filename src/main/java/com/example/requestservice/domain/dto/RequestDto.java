package com.example.requestservice.domain.dto;


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
        @JsonSubTypes.Type(value = SomeRequestDto.class),
        @JsonSubTypes.Type(value = AnotherRequestDto.class)
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class RequestDto {
    private String id;
}
