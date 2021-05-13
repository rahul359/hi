package com.rahul.program.rooms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rahul.program.rooms.model.Room;

@Repository

public interface RoomRepository extends MongoRepository<Room ,String> {
	
	@Query("{'name': ?0}")
	
	 
	Optional<Room> findByRoom(Long roomNo);

	List<Room> findAllByStatus(boolean b);



}

	
