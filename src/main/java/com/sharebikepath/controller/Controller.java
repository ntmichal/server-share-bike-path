package com.sharebikepath.controller;


import com.sharebikepath.dto.MeetingDTO;
import com.sharebikepath.dto.PointDTO;
import com.sharebikepath.entities.Meeting;
import com.sharebikepath.entities.Point;
import com.sharebikepath.repository.interfaces.RepositoryInterface;
import com.sharebikepath.services.OpenRouteServiceConnector;
import com.sharebikepath.services.models.Coordinates;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/meeting")
@CrossOrigin(origins = "http://localhost:4200/**", allowedHeaders = "*")
public class Controller {


    private RepositoryInterface repositoryInterface;
    private OpenRouteServiceConnector openRouteServiceConnector;

    public Controller(RepositoryInterface repositoryInterface,
    OpenRouteServiceConnector openRouteServiceConnector) {
        this.repositoryInterface = repositoryInterface;
        this.openRouteServiceConnector = openRouteServiceConnector;
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

    @PostMapping(path="route")
    public Object getRoute(@RequestBody Coordinates coordinates){

        ResponseEntity responseEntity = openRouteServiceConnector.getRoute(coordinates);

        return responseEntity.getBody();
    }


}
