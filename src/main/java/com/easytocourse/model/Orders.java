package com.easytocourse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue
	private int id;

	private String c_unique_id;
	private int quantity;
	private String c_name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getC_unique_id() {
		return c_unique_id;
	}
	public void setC_unique_id(String c_unique_id) {
		this.c_unique_id = c_unique_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public Orders(String c_unique_id, int quantity, String c_name) {
		super();
		this.c_unique_id = c_unique_id;
		this.quantity = quantity;
		this.c_name = c_name;
	}
	public Orders(int id, String c_unique_id, int quantity, String c_name) {
		super();
		this.id = id;
		this.c_unique_id = c_unique_id;
		this.quantity = quantity;
		this.c_name = c_name;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", c_unique_id=" + c_unique_id + ", quantity=" + quantity + ", c_name=" + c_name
				+ "]";
	}
	

}
