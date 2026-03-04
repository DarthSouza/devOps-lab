package br.puc.devops.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHelloEndpoint() throws Exception {
        mockMvc.perform(get("/api/hello/João"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Olá, João")))
                .andExpect(content().string(containsString("DevOps Lab")));
    }

    @Test
    void testCalculateSum() throws Exception {
        mockMvc.perform(get("/api/calculate")
                        .param("a", "5")
                        .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sum").value(8.0))
                .andExpect(jsonPath("$.subtract").value(2.0))
                .andExpect(jsonPath("$.multiply").value(15.0))
                .andExpect(jsonPath("$.divide").value(1.6666666666666667));
    }

    @Test
    void testCalculateWithZeroDivision() throws Exception {
        mockMvc.perform(get("/api/calculate")
                        .param("a", "10")
                        .param("b", "0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sum").value(10.0))
                .andExpect(jsonPath("$.divide").isEmpty())
                .andExpect(jsonPath("$.error").value("Divisão por zero não permitida"));
    }

    @Test
    void testCalculateMissingParameters() throws Exception {
        mockMvc.perform(get("/api/calculate"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("obrigatórios")));
    }

    @Test
    void testCalculateWithNegativeNumbers() throws Exception {
        mockMvc.perform(get("/api/calculate")
                        .param("a", "-5")
                        .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sum").value(-2.0))
                .andExpect(jsonPath("$.subtract").value(-8.0));
    }

    @Test
    void testCalculateWithDecimals() throws Exception {
        mockMvc.perform(get("/api/calculate")
                        .param("a", "10.5")
                        .param("b", "2.5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sum").value(13.0))
                .andExpect(jsonPath("$.multiply").value(26.25));
    }

}

