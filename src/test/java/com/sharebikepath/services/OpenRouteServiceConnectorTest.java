package com.sharebikepath.services;

import com.sharebikepath.entities.Meeting;
import com.sharebikepath.entities.Point;
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

        List<Point> pointList = Meeting
                .builder()
                .addPoint(new Point(8.681495,49.41461))
                .addPoint(new Point(8.686507,49.41943))
                .addPoint(new Point(8.687872, 49.420318))
                .build().getPoints();

        ResponseEntity responseEntity = this.openRouteServiceConnector.getRoute(pointList);

        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }

}