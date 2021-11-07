package com.sharebikepath.repository.interfaces;

import com.sharebikepath.entities.Meeting;

import java.util.UUID;

public interface RepositoryInterface {

    Meeting getByUUID(UUID uuid);
    UUID save(Meeting meeting);
}
