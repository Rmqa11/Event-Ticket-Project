package com.ticket.ticket.controller;

import com.ticket.ticket.entity.RegisterUser;
import com.ticket.ticket.service.Implemntation.RegisterUserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.mockito.Mockito.when;

@SpringBootTest
class RegisterUserControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @MockBean
    private RegisterUserServiceImpl registerUserServiceImpl;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testCreateUser() throws Exception {
        RegisterUser user = new RegisterUser();
        user.setUsername("rahaf9");
        when(registerUserServiceImpl.createUser(user)).thenAnswer(invocation -> "User registered successfully");

        String registerUserJson = "{\n" +
                "  \"username\": \"rahaf9\",\n" +
                "  \"password\": \"rm11\",\n" +
                "  \"email\": \"Rahaf9@gmail.com\",\n" +
                "  \"role\": \"RegisterUser\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/create/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(registerUserJson))
                .andExpect(MockMvcResultMatchers.status().isOk()) // Expect HTTP 200
                .andExpect(MockMvcResultMatchers.content().string("User registered successfully"));
    }

    @Test
    public void testGetUser() throws Exception {
        RegisterUser registerUser = new RegisterUser();
        registerUser.setUserId(4);
        registerUser.setUsername("rmq4");
        when(registerUserServiceImpl.getUserById(4)).thenReturn(registerUser);

        mockMvc.perform(MockMvcRequestBuilders.get("/user/4"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("rmq4"));
    }
}