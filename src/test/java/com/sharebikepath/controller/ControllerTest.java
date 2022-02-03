package com.sharebikepath.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sharebikepath.dto.MeetingDTO;
import com.sharebikepath.dto.PointDTO;
import com.sharebikepath.dto.builder.MeetingDTOBuilder;
import com.sharebikepath.services.models.Coordinate;
import com.sharebikepath.services.models.Coordinates;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void get_route_from_external_service() throws Exception {
        MeetingDTO meetingDTO = MeetingDTO.builder()
                .addPoint(new PointDTO(20.993828, 52.242642))
                .addPoint(new PointDTO(20.988635,52.225038))
                .build();

        Coordinates coordinates = new Coordinates();
        coordinates.addPoint(new double[]{20.993828, 52.242642});
        coordinates.addPoint(new double[]{20.988635,52.225038});

        String pointsJSON = objectMapper.writeValueAsString(coordinates);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/meeting/route")
                        .content(pointsJSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }

}