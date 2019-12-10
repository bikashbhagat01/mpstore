package com.mobile.store;

public class MobilePhone {
	
	private static long mobileID = 1111;
	private long mid;
	private String brand;
	private double cost;
	private double camera;
	private int storage;
	private String type;
	
	public MobilePhone(MobilePhone phone) {
		this.brand = phone.brand;
		this.cost = phone.cost;
		this.camera = phone.camera;
		this.storage = phone.storage;
		this.type = phone.type;
		this.mid = mobileID;
	}
	public MobilePhone(){
		
	}
	public long getMobileID() {
		return mobileID;
	}

	public void setMobileID() {
		mobileID++;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		
		this.brand = brand;
	
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getCamera() {
		return camera;
	}

	public void setCamera(double camera) {
		this.camera = camera;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String toString(){
		
	return "Mobile ID : " + mid + "\nBrand : " + brand + "\nCost : Rs." + String.format("%.2f", cost) + "\nCamera : " + camera + "MP\nStorage : " + storage + "GB\nOS Type : "+ type;
		
	}
	public long getMid() {
		return mid;
	}
	public void setMid(long mid) {
		this.mid = mid;
	}
	

}
