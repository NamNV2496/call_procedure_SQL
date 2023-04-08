package com.example.callproceduresql.service;

import com.example.callproceduresql.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserService {
    private final EntityManager entityManager;

    public User getUser(User findUser) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("Procedure_Name", User.class);

        query.registerStoredProcedureParameter("p_name", String.class, ParameterMode.INOUT);
//        query.registerStoredProcedureParameter("p_name", String.class, ParameterMode.IN); // IN if only optional finding, not return this field in rerults
        query.registerStoredProcedureParameter("p_age", Long.class, ParameterMode.INOUT);
//        query.registerStoredProcedureParameter("p_place", String.class, ParameterMode.INOUT);

        query.setParameter("p_name", findUser.getName());
        query.setParameter("p_age", findUser.getAge());
        query.setParameter("p_place", findUser.getPlace());

//        2 way to execute query and get the result
//        WAY 1
        if ( 1 == 1) {
            query.execute();
            String returnName = (String) query.getOutputParameterValue("p_name");
            Long returnAge = (Long) query.getOutputParameterValue("p_age");
            String returnPlace = (String) query.getOutputParameterValue("p_place");
            return User.builder()
                        .name(returnName)
                        .age(returnAge)
                        .place(returnPlace)
                    .build();
        } else {
//        WAY 2
            return (User) query.getSingleResult();
        }
    }
}
