package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(MathController.class)
public class MathControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testAdd() throws Exception {
        mockMvc.perform(get("/add").param("a", "2").param("b", "3"))
               .andExpect(status().isOk())
               .andExpect(content().string("5"));
    }
    @Test
    public void testSubtract() throws Exception {
        mockMvc.perform(get("/subtract").param("a", "3").param("b", "2"))
               .andExpect(status().isOk())
               .andExpect(content().string("1"));
    }
}
