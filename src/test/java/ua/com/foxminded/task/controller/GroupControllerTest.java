package ua.com.foxminded.task.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import ua.com.foxminded.task.config.TestConfig;
import ua.com.foxminded.task.config.spring.mvc.WebConfig;

@SpringJUnitWebConfig(classes = { WebConfig.class, TestConfig.class })
public class GroupControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    public void setup(WebApplicationContext wac) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void getAccount() throws Exception {
        this.mockMvc.perform(get("/groups").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print());
    }

}
