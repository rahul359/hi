package com.rahul.program.search.controller;

import com.rahul.program.search.model.SearchRequest;


import com.rahul.program.search.service.SearchRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class SearchRoomController {
    @Autowired
    private SearchRoomService searchRoomService;

    //Returns all the available rooms
    @GetMapping("/room")
    public ResponseEntity<?> getAvailableRooms(@RequestBody SearchRequest searchRequest) {
        try {
            return searchRoomService.getAllAvailableRooms(searchRequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(Map.of("message", e.getMessage()));
        }
    }

    //Returns true or false for whether room is available or not
    @PostMapping("/room/check/{roomId}")
    public ResponseEntity<?> checkIsRoomAvailable(@RequestBody SearchRequest searchRequest, @PathVariable String roomId) {
        try {
            return searchRoomService.checkWhetherRoomIsAvailable(searchRequest, roomId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(Map.of("message", e.getMessage()));
        }
    }
}

