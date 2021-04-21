package com.rahul.program.rooms.exception;

public class RoomException extends Exception {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoomException(String message) {
		super(message);
	}
	
	public static String NotFoundException(String id) {
		return "Room With"+id+"not found";
	}

	public static String RoomAlreadyExists() {
		return "Room already Exists";
	}
	
}
