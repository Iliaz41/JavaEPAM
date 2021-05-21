package com.example.restservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testingException() {
        try {
            this.mockMvc.perform(get("/greeting?string=assffffgggdddd&b=d"))
                    .andDo(print())
                    .andExpect(content().json("{\"Result:\":4}"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
