package com.hotel.roomservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.roomservice.dto.RoomRequest;
import com.hotel.roomservice.dto.RoomResponse;
import com.hotel.roomservice.model.Room;
import com.hotel.roomservice.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomResponse create(RoomRequest roomRequest) {
        System.out.println("Room object from service " + roomRequest);
        // roomrequest => roomobject
        Room rm = Room.builder()
                .no(roomRequest.getNo())
                .price(roomRequest.getPrice())
                .build();

        System.out.println(rm);

       // saved room -> roomresponse 
       Room savedRoom = roomRepository.save(rm);
       RoomResponse roomResponse = RoomResponse.builder().id(savedRoom.getId()).no(savedRoom.getNo()).price(savedRoom.getPrice()).build();
       return roomResponse;
        

    }

    public List<RoomResponse> viewAll() {
       List<Room> roomList = roomRepository.findAll();
       //convert karanwa stream karala eka pass krnwa map washayen
       List<RoomResponse> roomResponses = roomList.stream().map(room -> createRoomResponse(room)).toList();
       return roomResponses;
    }

    private RoomResponse createRoomResponse(Room room) {
       return RoomResponse.builder().id(room.getId()).no(room.getNo()).price(room.getPrice()).build();
    }

    //optional kiynne thyannat puluwan nati wennat puluwan
    public RoomResponse getOne(String id) {
        Optional<Room> optionalRoom =  roomRepository.findById(id);
        if (optionalRoom.isPresent()) {
           Room room = optionalRoom.get();
           RoomResponse roomResponse = createRoomResponse(room);
           return roomResponse;
        }else{
            return null;
        }
    }




    

}
