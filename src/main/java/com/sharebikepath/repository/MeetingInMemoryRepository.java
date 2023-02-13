package com.sharebikepath.repository;

import com.sharebikepath.entities.Meeting;
import com.sharebikepath.entities.Point;
import com.sharebikepath.repository.interfaces.RepositoryInterface;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class MeetingInMemoryRepository implements RepositoryInterface {

    private Map<UUID, Meeting> meetingHashMap = new HashMap<UUID, Meeting>();

//    public MeetingInMemoryRepository(){
//        UUID uuidTest = UUID.fromString("39f913e2-b8ce-469f-b2cb-13a313163dd8");
//        Meeting meeting = Meeting.builder()
//                .setID(uuidTest)
//                .setName("Test path")
//                .addPoint(new Point(1l,20.897770194467046,52.237360321604534))
//                .addPoint(new Point(2l,20.99537729362339, 52.27624775756698))
//                .addPoint(new Point(3l,21.019218111226085, 52.213822451849225))
//                .addPoint(new Point(4l, 20.97390554664344, 52.15055164427725))
//                .build();
//        meetingHashMap.put(uuidTest, meeting);
//    }

    @Override
    public Meeting getByUUID(UUID uuid) {
        return meetingHashMap.get(uuid);
    }

    @Override
    public List<Point> getMeetingWaypoints(UUID uuid){
        return meetingHashMap
                .get(uuid)
                .getPoints();
    }

    @Override
    public UUID save(Meeting meeting) {
        UUID randomUUID = UUID.randomUUID();

        Meeting meetingToSave = Meeting.builder()
                    .setID(randomUUID)
                    .setName(meeting.getName())
                    .setPoints(meeting.getPoints())
                .build();

        meetingHashMap.put(randomUUID, meetingToSave);

        return randomUUID;
    }

    @Override
    public Point addMeetingPoint(UUID meetingId, Point point) {
        Meeting meeting = this.getByUUID(meetingId);

        int pointCount;
        if(meeting.getPoints() != null){
            pointCount = meeting.getPoints().size();
        }else{
            pointCount = 0;
        }

        point.setId(pointCount + 1l);

        meeting.addPoint(point);

        return point;
    }

    @Override
    public Point updateMeetingPoint(UUID meetingId, Point point) {
        return this.getByUUID(meetingId)
                .updatePoint(point);

    }
}
