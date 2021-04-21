package com.rahul.program.rooms.service;

import java.util.ArrayList;




import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.rahul.program.rooms.exception.RoomException;
import com.rahul.program.rooms.model.Room;
import com.rahul.program.rooms.repository.RoomRepository;

@Service
@CrossOrigin(origins="http://localhost:3000")
public class RoomServiceImpl implements RoomService{
	@Autowired
	private RoomRepository roomRepo;

	@Override
	public void createRoom(Room room) throws ConstraintViolationException, RoomException {
		// TODO Auto-generated method stub
		Optional<Room>  roomOptional = roomRepo.findByRoom(room.getRoomNo());
		if (roomOptional.isPresent()) {
			throw new RoomException(RoomException.RoomAlreadyExists());
			
		}else {
			roomRepo.save(room);
		}		
	}

	@Override
	public List<Room> getAllRooms() {
		List<Room> rooms = roomRepo.findAll();
		if (rooms.size() > 0) {
			return rooms;
		}else {
			return new ArrayList<Room>();
		}
		
	}

	@Override
	public Room getSingleRoom(String id) throws RoomException {
		Optional<Room> optionalRoom = roomRepo.findById(id);
		if (!optionalRoom.isPresent() ) {
			throw new RoomException(RoomException.NotFoundException(id));
		}else {
			return optionalRoom.get();
		}
	}

	@Override
	public void updateRoom(String id, Room room) throws RoomException {
		Optional<Room> roomWithId = roomRepo.findById(id);
		if(roomWithId.isPresent()) {
			Room roomToUpdate = roomWithId.get();
			roomToUpdate.setRoomNo(room.getRoomNo());
			roomToUpdate.setType(room.getType());
			roomToUpdate.setNoOfGuests(room.getNoOfGuests());
			roomToUpdate.setPricePerDay(room.getPricePerDay());
			
			roomToUpdate.setStatus(room.isStatus());
			
			roomRepo.save(roomToUpdate);
	
			
		}else {
			throw new RoomException(RoomException.NotFoundException(id));
		}		
	}

	@Override
	public void deleteRoomById(String id) throws RoomException {
		Optional<Room> roomOptional = roomRepo.findById(id);
		if(!roomOptional.isPresent()) {
			throw new RoomException(RoomException.NotFoundException(id));
		}else {
			roomRepo.deleteById(id);
		}
		
	}
	
	
	
	
	
	
	
	

}
