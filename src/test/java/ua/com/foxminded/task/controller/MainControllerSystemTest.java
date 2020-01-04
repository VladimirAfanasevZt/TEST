package ua.com.foxminded.task.controller;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class MainControllerSystemTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
//    private Logger logger = LoggerFactory.getLogger(StudentController.class);
//    private MainController mainController = new MainController(logger);

    @BeforeEach
    public void init() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//        this.mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    void whenRetriveMainPage_thenExpectMainView() throws Exception {
        String expectedViewName = "main";
        String expectedTitle = "Thymeleaf+SpringMVC University";
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name(expectedViewName))
                .andExpect(content().string(allOf(containsString("<title>" + expectedTitle + "</title>"))))
                .andDo(print())
                .andReturn();
    }

}
