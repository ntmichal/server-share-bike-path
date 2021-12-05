package com.sharebikepath.repository;

import com.sharebikepath.entities.Meeting;
import com.sharebikepath.entities.Point;
import com.sharebikepath.repository.interfaces.RepositoryInterface;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class MeetingRepository implements RepositoryInterface {

    private Map<UUID, Meeting> meetingHashMap = new HashMap<UUID, Meeting>();

    public MeetingRepository(){
        UUID uuidTest = UUID.fromString("39f913e2-b8ce-469f-b2cb-13a313163dd8");
        Meeting meeting = Meeting.builder()
                .setID(uuidTest)
                .setName("Test path")
                .addPoint(new Point(1l,20.897770194467046,52.237360321604534))
                .addPoint(new Point(2l,20.99537729362339, 52.27624775756698))
                .addPoint(new Point(3l,21.019218111226085, 52.213822451849225))
                .addPoint(new Point(4l, 20.97390554664344, 52.15055164427725))
                .build();
        meetingHashMap.put(uuidTest, meeting);
    }

    @Override
    public Meeting getByUUID(UUID uuid) {
        return meetingHashMap.get(uuid);
    }

    @Override
    public UUID save(Meeting meeting) {
        Meeting savingMeeting = new Meeting();
        UUID randomUUID = UUID.randomUUID();
        savingMeeting.setMeetingId(randomUUID);
        savingMeeting.setName(meeting.getName());
        savingMeeting.setPoints(meeting.getPoints());
        meetingHashMap.put(randomUUID, savingMeeting);

        return randomUUID;
    }

}
