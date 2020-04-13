package com.hotel.application.entity;

import java.util.List;

import javax.persistence.CascadeType;
import com.sun.xml.internal.ws.developer.StreamingAttachment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.hotel.application.entity.Room;

import jdk.internal.instrumentation.TypeMapping;

@Entity
@Table(name="reservation")
public class Reservation {
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reservation_id")
	private long id;

	@Column(name="price")
    private double price;
	
	@Column(name="check_in")
    private String checkIn;
    
    @Column(name="check_out")
    private String checkOut;
    
    @Column(name="num_rooms")
    private int numRooms;
    
    @Column(name="num_guests")
    private int numGuests;
    
    @Column(name="email")
    private String email;
    
    @Column(name="room_Type")
    private String roomType;
    
    @OneToMany(mappedBy="reservation")
    private List<Room> rooms;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="order_id")
    private Order order_id;
    
    
	public Order getOrder() {
		return order_id;
	}

	public void setOrder(Order order) {
		this.order_id = order;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public int getNumRooms() {
		return numRooms;
	}

	public void setNumRooms(int numRooms) {
		this.numRooms = numRooms;
	}

	public int getNumGuests() {
		return numGuests;
	}

	public void setNumGuests(int numGuests) {
		this.numGuests = numGuests;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", numRooms=" + numRooms
				+ ", numGuests=" + numGuests + ", email=" + email + "]";
	}	
    
    
	

}
