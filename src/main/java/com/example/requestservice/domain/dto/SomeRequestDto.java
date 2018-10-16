package com.example.requestservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SomeRequestDto extends RequestDto {
    private String someStringField;
    private Integer someIntegerField;

    public SomeRequestDto(String id, String someStringField, Integer someIntegerField) {
        super(id);
        this.someStringField = someStringField;
        this.someIntegerField = someIntegerField;
    }
}