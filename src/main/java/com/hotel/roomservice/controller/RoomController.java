package com.hotel.roomservice.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.hotel.roomservice.dto.RoomRequest;
import com.hotel.roomservice.dto.RoomResponse;
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
    public RoomResponse create(@RequestBody RoomRequest roomRequest) {
        System.out.println("Room Service Called");
        System.out.println(roomRequest);

       return roomService.create(roomRequest);
       

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RoomResponse> viewAll(){
        System.out.println("OK");
      return roomService.viewAll();
    }

    @GetMapping(value = "/{getid}")
    @ResponseStatus(HttpStatus.OK)
    public RoomResponse getOne(@PathVariable String getid){
        System.out.println(getid);
        RoomResponse roomResponse = roomService.getOne(getid);
        return roomResponse;
    }
}
