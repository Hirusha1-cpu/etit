package com.hotel.roomservice.service;

import org.springframework.stereotype.Service;

import com.hotel.roomservice.dto.RoomRequest;
import com.hotel.roomservice.model.Room;
import com.hotel.roomservice.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public void create(RoomRequest roomRequest) {
        System.out.println("Room object from service " + roomRequest);
        // roomrequest => roomobject
        Room rm = Room.builder()
                .no(roomRequest.getNo())
                .price(roomRequest.getPrice())
                .build();

        System.out.println(rm);


        // save 
        roomRepository.save(rm);

    }
}
