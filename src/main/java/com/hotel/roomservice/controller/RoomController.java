package com.hotel.roomservice.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.hotel.roomservice.dto.RoomRequest;
import com.hotel.roomservice.service.RoomService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor // constructor eka hadanw dependency eka inject karala denwa
public class RoomController {
    // @Autowired
    private final RoomService roomService; // final eken wenne wena thanakin override kala nohaka


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody RoomRequest roomRequest) {
        System.out.println("Room Service Called");
        System.out.println(roomRequest);

        roomService.create(roomRequest);
       

    }
}
