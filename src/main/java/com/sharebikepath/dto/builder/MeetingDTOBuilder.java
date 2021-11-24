package com.sharebikepath.dto.builder;

import com.sharebikepath.dto.MeetingDTO;
import com.sharebikepath.dto.PointDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MeetingDTOBuilder{

    private UUID id;
    private String name;
    private List<PointDTO> pointList;

    public MeetingDTOBuilder() {
    }

    public MeetingDTOBuilder setID(UUID uuid){
        this.id = uuid;
        return this;
    }
    public MeetingDTOBuilder setName(String name){
        this.name = name;
        return this;
    }

    public MeetingDTOBuilder setPoints(List<PointDTO> pointDTOList){
        pointList = pointDTOList;
        return this;
    }

    public MeetingDTOBuilder addPoint(PointDTO point){
        if(pointList == null){
            pointList = new ArrayList<>();
            pointList.add(point);
        }else{
            pointList.add(point);
        }
        return this;
    }

    public MeetingDTO build(){
        MeetingDTO meeting = new MeetingDTO();
        meeting.setName(name);
        meeting.setPoints(pointList);
        return meeting;
    }


}
