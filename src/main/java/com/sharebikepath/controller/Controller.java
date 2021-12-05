package com.sharebikepath.controller;


import com.sharebikepath.dto.MeetingDTO;
import com.sharebikepath.dto.PointDTO;
import com.sharebikepath.entities.Meeting;
import com.sharebikepath.entities.Point;
import com.sharebikepath.repository.interfaces.RepositoryInterface;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "meeting")
public class Controller {


//    "39f913e2-b8ce-469f-b2cb-13a313163dd8"

    private RepositoryInterface repositoryInterface;

    public Controller(RepositoryInterface repositoryInterface) {
        this.repositoryInterface = repositoryInterface;
    }

    @GetMapping(path = "get")
    public MeetingDTO getMeeting(@RequestParam String eventId){
        UUID meetingId = UUID.fromString(eventId);
        Meeting meeting = repositoryInterface.getByUUID(meetingId);
        return MeetingDTO.builder()
                .setID(meeting.getMeetingId().toString())
                .setName(meeting.getName())
                .setPoints(meeting.getPoints().stream().map(PointDTO::PointDTOFromPoint).collect(Collectors.toList()))
                .build();
    }


    @PostMapping(path="save")
    public void saveMeeting(MeetingDTO meetingDTO){
        Meeting meeting = Meeting.builder()
                .setName(meetingDTO.getName())
                .setPoints(meetingDTO.getPoints().stream().map(Point::PointFromPointDTO).collect(Collectors.toList()))
                .build();

        repositoryInterface.save(meeting);
    }
}
