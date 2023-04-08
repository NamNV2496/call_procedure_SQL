package com.example.callproceduresql.domain;

import lombok.*;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NamedStoredProcedureQuery(name = "User.getTotalUserWithAge", procedureName = "getTotalUserWithAge", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.INOUT, name = "age", type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "name", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "place", type = String.class) })
public class UserWAY2 {
    @Id
    Long id;
    String name;
    Long age;
    String place;
}
