package com.practice.rest.controller.v1;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class SignControllerTest {
    @Autowired private MockMvc mockMvc;

    @Test
    public void signin() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("id", "hhjin1814@gmail.com");
        params.add("password", "asdf");
        mockMvc
            .perform(post("/v1/signin").params(params))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.success").value(true))
            .andExpect(jsonPath("$.code").value(0))
            .andExpect(jsonPath("$.msg").exists())
            .andExpect(jsonPath("$.data").exists());
    }
    @Test
    public void signup() throws Exception{
        long epochTime = LocalDateTime.now()
                .atZone(ZoneId.systemDefault())
                .toEpochSecond();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("id", "ppojin_" + epochTime + "@naver.com");
        params.add("password", "asdfg");
        params.add("name", "ppojin_" + epochTime);
        mockMvc
            .perform(post("/v1/signup").params(params))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.success").value(true))
            .andExpect(jsonPath("$.code").value(0))
            .andExpect(jsonPath("$.msg").exists());
    }

    @Test
    @WithMockUser(username = "mockUser", roles = {"ADMIN"})
    public void accessdenied() throws Exception{
        mockMvc
            .perform(MockMvcRequestBuilders.get("/v1/users"))
            .andExpect(forwardedUrl("/exception/accessdenied"));
    }
}