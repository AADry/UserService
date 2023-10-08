package com.example.userservice;

import com.example.userservice.dto.UserAuthDto;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
class UserControllerTest {
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> container = new PostgreSQLContainer<>()
            .withUsername("postgres")
            .withPassword("postgres");
    private final static Gson gson = new Gson();
    @Autowired
    private MockMvc mvc;

    @Test
    void valid_request_returns_200() throws Exception {
        mvc.perform(post("/api/user-service/register")
                        .contentType("application/json")
                        .content(gson.toJson(new UserAuthDto("bob", "wanna_reg"))))
                .andExpect(status().isOk());

    }

    @Test
    void invalid_request_returns_200() throws Exception {
        mvc.perform(post("/api/user-service/register")
                        .contentType("application/json")
                        .content(gson.toJson(new UserAuthDto("bob", "wanna_log"))))
                .andExpect(status().isOk());
    }
}
