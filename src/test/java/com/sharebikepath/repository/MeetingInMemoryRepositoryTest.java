package com.sharebikepath.repository;

import com.sharebikepath.entities.Meeting;
import com.sharebikepath.entities.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MeetingInMemoryRepositoryTest {

    private MeetingInMemoryRepository meetingRepository;
    private UUID randomUUID;

    @BeforeEach
    void setUp(){
        meetingRepository = new MeetingInMemoryRepository();
        randomUUID = UUID.randomUUID();

    }

    @Test
    void givenEmptyRepository_whenSaveMeeting_thenReturnUUID() {
        Meeting meeting = Meeting.builder()
                .setName("Set meeting")
                .build();

        UUID result = meetingRepository.save(meeting);

        assertNotNull(result);


    }
    @Test
    void givenEmptyRepository_whenGetUUID_thenReturnNull(){
        Meeting result = meetingRepository.getByUUID(randomUUID);

        assertNull(result);
    }


    @Test
    void givenSavedMeeting_whenGetByUUID_thenReturnMeeting(){
        Meeting meeting = Meeting.builder()
                .setName("Meeting")
                .build();
        UUID uuid = meetingRepository.save(meeting);

        Meeting result = meetingRepository.getByUUID(uuid);

        assertEquals(uuid, result.getMeetingId());
        assertEquals(meeting.getName(),result.getName());

    }

    @Test
    void givenMeetingWithWaypoints_whenGetByUUID_thenReturnPoints(){
        Meeting meeting = Meeting.builder()
                .setName("Meeting")
                .addPoint(new Point(1l,20.897770194467046,52.237360321604534))
                .addPoint(new Point(2l,20.99537729362339, 52.27624775756698))
                .build();

        UUID uuid = meetingRepository.save(meeting);

        List<Point> result = meetingRepository.getMeetingWaypoints(uuid);
        assertEquals(2, result.size());

    }
    @Test
    void givenMeetingWithoutWaypoints_whenAddWaypoint_thenReturnPoints(){
        Meeting meeting = Meeting.builder()
                .setName("Meeting")
                .build();
        UUID meetingId = meetingRepository.save(meeting);

        Point point1 = new Point(20.897770194467046,52.237360321604534);
        Point point2 = new Point(20.99537729362339, 52.27624775756698);

        meetingRepository.addMeetingPoint(meetingId,point1);
        meetingRepository.addMeetingPoint(meetingId,point2);

        List<Point> points = meetingRepository.getMeetingWaypoints(meetingId);

        assertEquals(2,points.size());

    }

    @Test
    void givenMeetingWithWaypoints_whenModifyPoint_thenReturnModifiedPoint(){
        Meeting meeting = Meeting.builder()
                .setName("Meeting")
                .addPoint(new Point(1l,20.897770194467046,52.237360321604534))
                .addPoint(new Point(2l,20.99537729362339, 52.27624775756698))
                .addPoint(new Point(3l,20.99537729362339, 52.27624775756698))
                .build();
        UUID meetingId = meetingRepository.save(meeting);

        Point pointToModify = new Point(2l,32.12, 45.12);

        meetingRepository.updateMeetingPoint(meetingId, pointToModify);

        List<Point> pointResult = meetingRepository.getMeetingWaypoints(meetingId);

        Point result = pointResult.get(1);

        assertEquals(pointToModify, result);

    }
}