package com.sharebikepath.controller;


import com.sharebikepath.entities.Meeting;
import com.sharebikepath.repository.interfaces.RepositoryInterface;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "meeting")
public class Controller {


//    "39f913e2-b8ce-469f-b2cb-13a313163dd8"

    private RepositoryInterface repositoryInterface;
    public Controller(RepositoryInterface repositoryInterface) {
        this.repositoryInterface = repositoryInterface;
    }

    @GetMapping(path = "get")
    public Meeting getRoomID(@RequestParam String eventId){
        UUID meetingId = UUID.fromString(eventId);

        return repositoryInterface.getByUUID(meetingId);
    }



}
