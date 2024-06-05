package com.ntech.nuton.nutonbe.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntech.nuton.nutonbe.dto.UserDTO;

@RestController
@RequestMapping("/register/v1")
public class RegistrationController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registerUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok().build();
    }
    
}
