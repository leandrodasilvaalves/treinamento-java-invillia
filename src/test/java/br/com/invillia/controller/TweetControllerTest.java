package br.com.invillia.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.invillia.dto.TweetDTO;
import br.com.invillia.service.TweetService;

@AutoConfigureMockMvc
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TweetController.class)
public class TweetControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TweetService service;

    @Test
    public void shouldReturnTweets() throws Exception {
        given(service.getTweet()).willReturn(Arrays.asList(new TweetDTO("Java é legal!")));

        mvc.perform(get("/tweet/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].tweet", equalTo("Java é legal!")));
    }

}
