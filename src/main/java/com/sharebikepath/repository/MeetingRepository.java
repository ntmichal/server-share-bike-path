package com.sharebikepath.repository;

import com.sharebikepath.entities.Meeting;
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
                .setName("Test trip")
                .build();
        meetingHashMap.put(uuidTest, meeting);
    }

    @Override
    public Meeting getMeetingByUUID(UUID uuid) {
        return meetingHashMap.get(uuid);
    }
}
