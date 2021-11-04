package com.sharebikepath.entities.builder;

import com.sharebikepath.entities.Meeting;

import java.util.UUID;

public class MeetingBuilder{

        private UUID id;
        private String name;

        public MeetingBuilder() {
        }

        public MeetingBuilder setID(UUID uuid){
            this.id = uuid;
            return this;
        }
        public MeetingBuilder setName(String name){
            this.name = name;
            return this;
        }

        public Meeting build(){
            Meeting meeting = new Meeting();
            meeting.setMeetingId(id);
            meeting.setName(name);
            return meeting;
        }


}

