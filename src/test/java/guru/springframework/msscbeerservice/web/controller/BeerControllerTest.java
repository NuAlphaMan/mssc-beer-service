package guru.springframework.msscbeerservice.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbeerservice.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    final String uriTemp = "/api/v1/beer/";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get(uriTemp + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        mockMvc.perform(post(uriTemp).contentType(MediaType.APPLICATION_JSON).content(getBeerDtoJson()))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        mockMvc.perform(put(uriTemp + UUID.randomUUID().toString()).contentType(MediaType.APPLICATION_JSON)
                .content(getBeerDtoJson())).andExpect(status().isNoContent());
    }

    String getBeerDtoJson() throws JsonProcessingException {
        return objectMapper.writeValueAsString(BeerDto.builder().build());
    }
}