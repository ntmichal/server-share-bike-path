package com.sharebikepath.repository;

import com.sharebikepath.entities.Meeting;
import com.sharebikepath.entities.Point;
import com.sharebikepath.repository.interfaces.RepositoryInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MeetingRepositoryTest {

    @Autowired
    private RepositoryInterface repositoryInterface;

    @Test
    void getMeetingWhichIsNotExist(){
        UUID randomUUID = UUID.randomUUID();
        Meeting meeting = repositoryInterface.getByUUID(randomUUID);

        assertNull(meeting);
    }

    @Test
    void saveAndGetMeeting(){

        Meeting meeting = Meeting
                .builder()
                .setName("Test Meeting")
                .addPoint(new Point(1,1))
                .addPoint(new Point(1,1))
                .build();

        UUID meetingUUID = repositoryInterface.save(meeting);

        assertNotNull(meetingUUID);

        Meeting meetingFromRepository = repositoryInterface.getByUUID(meetingUUID);

        assertEquals(meetingUUID, meetingFromRepository.getMeetingId());


    }
}