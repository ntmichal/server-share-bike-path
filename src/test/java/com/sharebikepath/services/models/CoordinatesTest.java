package com.sharebikepath.services.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CoordinatesTest {

    @Test
    void return_coordinates_in_proper_format() throws JsonProcessingException {
        String coordinatesJson = "{\"coordinates\":[[8.681495,49.41461],[8.686507,49.41943],[8.687872,49.420318]]}";

        Coordinates coordinates = new Coordinates();
        coordinates.addPoint(new double[]{8.681495,49.41461});
        coordinates.addPoint(new double[]{8.686507,49.41943});
        coordinates.addPoint(new double[]{8.687872, 49.420318});


        assertEquals(coordinatesJson,coordinates.toJSONString());

    }
}