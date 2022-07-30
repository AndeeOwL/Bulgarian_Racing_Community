package com.andreanbuhchev.bulgarian_racing_community.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RegisterControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testRegistrationPageShown() throws Exception {
        mockMvc.perform(get("/users/register")).andExpect(status().isOk()).andExpect(view().name("register"));
    }

    @Test
    void testUserRegister() throws Exception {
        mockMvc.perform(post("/users/register")
                .param("username","ivan")
                .param("firstName","ivan")
                .param("lastName","ivanov")
                .param("email","ivan@ivanov")
                .param("password","12345678")
                .param("confirmPassword","12345678")
                .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/home"));
    }
}
