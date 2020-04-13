//anh

package com.hotel.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.application.entity.Room;
import com.hotel.application.entity.RoomType;
import com.hotel.application.service.RoomService;


@Controller
@RequestMapping("/room")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@GetMapping
	public String listRoom(Model theModel) {
		List<RoomType> roomTypes = roomService.listOfType();

		theModel.addAttribute("roomTypes", roomTypes);
		return "display-room-types";
	}

	@GetMapping("/new-room-type-form")
	public String addTypeForm(Model theModel) {
		Room room = new Room();
		theModel.addAttribute("room", room);

		return "new-room-type-form";
	}

	@PostMapping("/add-type")
	public String addType(@ModelAttribute("room") Room room, Model theModel) {
		roomService.save(room);
		List<RoomType> roomTypes = roomService.listOfType();

		theModel.addAttribute("roomTypes", roomTypes);
		return "display-room-types";
	}

	@PutMapping("/update-type")
	public String updateType(Model theModel, @ModelAttribute("type") RoomType type) {

		return "display-room-types";
	}

	@RequestMapping("/type/{typeName}")
	public String addTypeForm(Model theModel, @PathVariable("typeName") String typeName) {
		List<Room> rooms = roomService.listByType(typeName);
		theModel.addAttribute("rooms", rooms);
		theModel.addAttribute("type", typeName);
		theModel.addAttribute("price", String.valueOf(rooms.get(0).getPrice()));
		return "room-by-type";
	}

	@RequestMapping("/delete/{roomNumber}/{typeName}")
	public String deleteRoomType(Model model, @PathVariable("roomNumber") String id,
			@PathVariable("typeName") String typeName) {

		Room room = roomService.get(Integer.parseInt(id));
		if (room.getReservation() == null) {
			roomService.delete(room);
		}
		List<Room> rooms = roomService.listByType(typeName);
		model.addAttribute("rooms", rooms);
		model.addAttribute("type", typeName);
		return "room-by-type";
	}

	@RequestMapping("/add/{typeName}/{price}")
	public String newRoomForm(Model theModel, @PathVariable("typeName") String typeName,
			@PathVariable("price") String price) {

		theModel.addAttribute("price", price);
		theModel.addAttribute("typeName", typeName);

		Room room = new Room();
		//room.setPrice(Double.parseDouble(price));
		//room.setTypeName(typeName);

		theModel.addAttribute("room", room);

		return "new-room-form";
	}

	@PutMapping("/add-room")
	public String addRoom(Model theModel, @ModelAttribute("room") Room room ) {

		System.out.println("room " + room.getFloor() + " " + room.getTypeName());
		roomService.save(room);
		String typeName = room.getTypeName();
		List<Room> rooms = roomService.listByType(typeName);
		theModel.addAttribute("rooms", rooms);
		theModel.addAttribute("type", typeName);
		return "room-by-type";
	}
}