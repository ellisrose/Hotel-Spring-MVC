package com.hotel.application.entity;

import javax.persistence.Id;

public class RoomType {
	@Id
	private String typeName;
	private double price;

	public RoomType(String typeName, double price) {
		this.typeName = typeName;
		this.price = price;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
