package com.example.callproceduresql.controller;

import com.example.callproceduresql.domain.User;
import com.example.callproceduresql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/getUserPlace")
    public String getUserPlaceFromProcedure() {
        User user = User.builder().name("Test1").age(23L).build();
        User returnUser = userService.getUser(user);

        return returnUser.getPlace();
    }
}
