package com.hotel.application.dao;

import java.util.List;

import com.hotel.application.entity.Room;
import com.hotel.application.entity.RoomType;


public interface RoomDAO {
	
	public void save(Room room);
	public void delete(Room room);
	public Room get(int roomNumber);
	
	public List<Room> listAll();
	
	public List<Room> listByType(String roomType);
	
	//public List<Room> listOfType();
	public List<RoomType> listOfType();
}