package com.hotel.application.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.application.dao.RoomDAO;
import com.hotel.application.entity.Room;
import com.hotel.application.entity.RoomType;



@Service
@Transactional
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomDAO roomDAO;
	
	@Override
	public void save(Room room) {
		roomDAO.save(room);
		
	}

	@Override
	public void delete(Room room) {
		roomDAO.delete(room);
	}


	@Override
	public Room get(int roomNumber) {
		return roomDAO.get(roomNumber);
	}

	@Override
	public List<Room> listAll() {
		return roomDAO.listAll();
	}

	@Override
	public List<Room> listByType(String roomType) {
		return roomDAO.listByType(roomType);
	}

//	@Override
//	public List<Room> listOfType() {
//		return roomDAO.listOfType();
//	}
	
	@Override
	public List<RoomType> listOfType() {
		return roomDAO.listOfType();
	}

}
