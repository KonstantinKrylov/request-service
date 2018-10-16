package com.example.requestservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnotherRequestDto extends RequestDto {
    private String anotherStringField;
    private Integer anotherIntegerField;

}
