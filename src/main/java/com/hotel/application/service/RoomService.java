package com.hotel.application.service;

import java.util.List;

import com.hotel.application.entity.Room;
import com.hotel.application.entity.RoomType;


public interface RoomService {
	public void save(Room room);
	public void delete(Room room);
	public Room get(int roomNumber);
	
	public List<Room> listAll();
	
	public List<Room> listByType(String roomType);
	
	public List<RoomType> listOfType();
	//public List<Room> listOfType();
}

