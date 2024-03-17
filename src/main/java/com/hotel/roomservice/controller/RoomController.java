package com.hotel.roomservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.roomservice.dto.RoomRequest;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    @PostMapping
    public void create(@RequestBody RoomRequest roomRequest) {
        System.out.println("Room Service Called");
        System.out.println(roomRequest);

    }
}
