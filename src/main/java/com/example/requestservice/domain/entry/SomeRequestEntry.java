package com.example.requestservice.domain.entry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SomeRequestEntry extends RequestEntry {

    private String someStringField;
    private Integer someIntegerField;

}
