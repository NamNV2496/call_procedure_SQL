package com.example.callproceduresql.repository;

import com.example.callproceduresql.domain.UserWAY2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositoryWAY2 extends JpaRepository<UserWAY2, Long> {

    @Procedure
    int GET_TOTAL_USER_BY_AGE(Long age);

    @Procedure("GET_TOTAL_USER_BY_AGE")
    int getTotalUserByAgeProcedureName(Long age);

    @Procedure(name = "User.getTotalUserByAge")
    int getTotalUserByAge(Long age);

    @Query(value = "CALL FIND_USER_AFTER_YEAR(:year_in);", nativeQuery = true)
    List<UserWAY2> findUserAfterYear(@Param("year_in") Long year);
}
