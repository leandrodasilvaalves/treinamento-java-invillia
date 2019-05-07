package br.com.invillia.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.invillia.dto.HashtagDTO;
import br.com.invillia.service.HashtagService;

@AutoConfigureMockMvc
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HashtagController.class)
public class HashtagControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private HashtagService service;

    @Test
    public void shouldReturnHastags() throws Exception {
        given(service.findAll()).willReturn(Arrays.asList(new HashtagDTO("TDD")));

        mvc.perform(get("/hashtag/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].hashtag", equalTo("TDD")));
    }

    @Test
    public void shouldSaveHashtag() throws Exception {
        HashtagDTO hashtagDTO = new HashtagDTO("TDD");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(hashtagDTO);

        mvc.perform(post("/hashtag/save").content(json).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
