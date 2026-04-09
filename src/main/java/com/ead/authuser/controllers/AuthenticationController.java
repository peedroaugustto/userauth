package com.ead.authuser.controllers;

import com.ead.authuser.controllers.dtos.UserRecordDTO;
import com.ead.authuser.services.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {

    final UserService userService;

    @PostMapping("signup")
    public ResponseEntity<Object> registerUser(@RequestBody
                                               @JsonView(UserRecordDTO.UserView.RegistrationPost.class)
                                               @Validated(UserRecordDTO.UserView.RegistrationPost.class)
                                               UserRecordDTO userRecordDTO) {
        if(userService.existsByUsername(userRecordDTO.username())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Username is already in use");
        }

        if(userService.existsByEmail(userRecordDTO.email())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Email is already in use");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(userRecordDTO));
    }
}
