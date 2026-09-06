package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Model.UserModel;
import com.example.ProyectoFinal.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel user) {
        UserModel savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }
}
