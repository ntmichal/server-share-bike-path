package com.sharebikepath.repository.interfaces;

import com.sharebikepath.entities.Meeting;
import com.sharebikepath.entities.Point;

import java.util.List;
import java.util.UUID;

public interface RepositoryInterface {

    Meeting getByUUID(UUID uuid);
    UUID save(Meeting meeting);
    List<Point> getMeetingWaypoints(UUID uuid);
    Point addMeetingPoint(UUID meetingId, Point point);
    Point updateMeetingPoint(UUID meetingId, Point point);
}
