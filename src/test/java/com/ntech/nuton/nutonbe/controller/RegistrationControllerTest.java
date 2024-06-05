package com.ntech.nuton.nutonbe.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ntech.nuton.nutonbe.dto.UserDTO;

@WebMvcTest(RegistrationController.class)
public class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void givenValidUserWhenUserRegisterThenReturnSuccessful() throws Exception {

        String content = asJsonString(
            new UserDTO("John", "Doe", "2022-01-01", "john@email.com", "encryptedPassword"));

        System.out.println(content);

        mockMvc.perform(MockMvcRequestBuilders.post("/register/v1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content))
            .andExpect(MockMvcResultMatchers.status().isOk());


    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
