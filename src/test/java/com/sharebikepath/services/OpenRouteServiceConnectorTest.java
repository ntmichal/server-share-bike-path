package com.sharebikepath.services;

import com.sharebikepath.entities.Meeting;
import com.sharebikepath.entities.Point;
import com.sharebikepath.services.models.Coordinate;
import com.sharebikepath.services.models.Coordinates;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OpenRouteServiceConnectorTest {


    @Autowired
    private OpenRouteServiceConnector openRouteServiceConnector;

    @Test
    void test_is_coordinates_sends_to_api(){

        Coordinates coordinates = new Coordinates();
        coordinates.addPoint(new double[]{20.993828, 52.242642});
        coordinates.addPoint(new double[]{20.988635,52.225038});


        ResponseEntity responseEntity = this.openRouteServiceConnector.getRoute(coordinates);

        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }

}