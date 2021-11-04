package com.sharebikepath.repository.interfaces;

import com.sharebikepath.entities.Meeting;

import java.util.UUID;

public interface RepositoryInterface {

    public Meeting getMeetingByUUID(UUID uuid);

}
