package com.sharebikepath.controller;


import com.sharebikepath.dto.MeetingDTO;
import com.sharebikepath.dto.PointDTO;
import com.sharebikepath.entities.Meeting;
import com.sharebikepath.entities.Point;
import com.sharebikepath.repository.interfaces.RepositoryInterface;
import com.sharebikepath.services.OpenRouteServiceConnector;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "meeting")
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

    @GetMapping(path="route")
    public Object getRoute(@RequestBody List<PointDTO> pointDTOList){

        List<PointDTO> pointDTOS = pointDTOList;
        List<Point> pointList = pointDTOList.stream().map(Point::PointFromPointDTO).collect(Collectors.toList());
        ResponseEntity responseEntity = openRouteServiceConnector.getRoute(pointList);

        return responseEntity.getBody();
    }
}
