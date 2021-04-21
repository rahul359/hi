package com.rahul.program.rooms.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.program.rooms.exception.RoomException;
import com.rahul.program.rooms.model.Room;
import com.rahul.program.rooms.repository.RoomRepository;
import com.rahul.program.rooms.service.RoomSearchService;
import com.rahul.program.rooms.service.RoomService;

import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolationException;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class RoomController {
	
	@Autowired
	private RoomRepository roomRepo;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private RoomSearchService roomSearchService;
	
	
	
	@GetMapping("/room")
	public ResponseEntity<?> getAllRooms() {
		List<Room> rooms = roomRepo.findAll();
		if (rooms.size() > 0) {
			return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
		}else {
			return new  ResponseEntity<>("No Rooms", HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	@PostMapping("/room")
	public ResponseEntity<?> createRoom(@RequestBody Room room) {
		try {
			roomService.createRoom(room);
			return new ResponseEntity<Room>(room, HttpStatus.OK);
		}
		catch( ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}catch (RoomException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	
	@GetMapping("/room/{id}")
	public  ResponseEntity<?> getSingleRoom(@PathVariable("id") String id) {
		try {
			return new ResponseEntity<>(roomService.getSingleRoom(id), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
    
    @GetMapping("/room/active")
    public ResponseEntity<?> getAllActiveRooms() {
        try {
            return roomSearchService.getAllActiveRooms();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(Map.of("message", e.getMessage()));
        }
    }
	
	
	@PutMapping("/room/{id}")
	public  ResponseEntity<?> updateById(@PathVariable("id") String id, @RequestBody Room room) {
		try {
			roomService.updateRoom(id, room);
			return new ResponseEntity<>("Updated Room with Id"+id, HttpStatus.OK);
		}catch (ConstraintViolationException e) {
			return new ResponseEntity<> (e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
			
		}catch (RoomException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/room/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
		try {
			roomService.deleteRoomById(id);
			return new ResponseEntity<> ("Successfully deleted with id"+id , HttpStatus.OK);
		} catch (RoomException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	

}
