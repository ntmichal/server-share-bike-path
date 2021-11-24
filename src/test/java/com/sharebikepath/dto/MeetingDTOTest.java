package com.sharebikepath.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MeetingDTOTest {

    @Test
    void addPointsToMeetingDTO_when_pointsList_isNull(){
        MeetingDTO meetingDTO = new MeetingDTO();
        PointDTO pointDTO = new PointDTO(10,20);
        meetingDTO.addPoint(pointDTO);

        PointDTO pointDTOtoCheck = new PointDTO(10,20);
        assertEquals(pointDTOtoCheck, meetingDTO.getPoints().get(0));
    }
}