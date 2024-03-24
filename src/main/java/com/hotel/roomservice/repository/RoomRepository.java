package com.hotel.roomservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hotel.roomservice.model.Room;

public interface RoomRepository extends MongoRepository<Room, String> {

    
} 
