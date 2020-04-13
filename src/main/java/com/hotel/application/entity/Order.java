package com.hotel.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderfood")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private long orderId;

	@Column(name="num_br")
	private int numBreakfast;

	@Column(name="num_lu")
	private int numLunch;
        
    @Column(name="num_di")
    private int numDinner;
        
    @Column(name="price")
    private double price;
    
    public Order() {}
        

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long id) {
        this.orderId = id;
    }

    public int getNumBreakfast() {
        return numBreakfast;
    }

    public void setNumBreakfast(int numBreakfast) {
        this.numBreakfast = numBreakfast;
    }

    public int getNumLunch() {
        return numLunch;
    }

    public void setNumLunch(int numLunch) {
        this.numLunch = numLunch;
    }

    public int getNumDinner() {
        return numDinner;
    }

    public void setNumDinner(int numDinner) {
        this.numDinner = numDinner;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

