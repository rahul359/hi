package com.rahul.program.rooms.service;

import javax.validation.ConstraintViolationException;


import com.rahul.program.rooms.exception.RoomException;
import com.rahul.program.rooms.model.Room;
import java.util.List;

public interface RoomService {
	
	public void createRoom(Room room) throws ConstraintViolationException,  RoomException;
	
	public List<Room> getAllRooms();
	
	public Room getSingleRoom(String id) throws RoomException;
	
	public void updateRoom(String id, Room room) throws RoomException;
	
	public void deleteRoomById(String id) throws RoomException;

	
	
	

}
