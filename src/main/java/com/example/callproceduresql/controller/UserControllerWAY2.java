package com.example.callproceduresql.controller;

import com.example.callproceduresql.domain.UserWAY2;
import com.example.callproceduresql.repository.UserRepositoryWAY2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserControllerWAY2 {
    private final UserRepositoryWAY2 userRepositoryWAY2;

    @GetMapping("/getUserWAY2")
    public List<UserWAY2> getUserPlaceFromProcedureWAY2() {
        return userRepositoryWAY2.findUserAfterYear(23L);
    }

    @GetMapping("/countUserByAge")
    public int getTotalUserByAgeProcedureNameWAY2() {
        return userRepositoryWAY2.getTotalUserByAgeProcedureName(23L);
    }

    @GetMapping("/countUserByAge2")
    public int getTotalUserByAgeFromProcedureWAY2() {
        return userRepositoryWAY2.getTotalUserByAge(23L);
    }
}
