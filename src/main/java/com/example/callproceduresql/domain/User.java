package com.example.callproceduresql.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    String name;
    Long age;
    String place;
}
