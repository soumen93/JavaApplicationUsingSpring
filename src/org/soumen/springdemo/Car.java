package org.soumen.springdemo;

public class Car {
	private String type;
	private String colour;
	private int price;
	private String milage;

	//one argument constructor
	public Car(String colour) {
		this.colour=colour;
	}
	
	//two argument constructor
	public Car(int price, String milage) {
		this.price=price;
		this.milage=milage;
	}
	
	public String getType() {
		return type;
	}
	
	//setter method
	public void setType(String type) {
		this.type = type;
	}



	public void start() {
		System.out.println(getType()+" is now started and the of the car is: "+this.colour);
		System.out.println("The price of the " +this.getType()+" is "+this.price +" and the milage is "+this.milage);
	}
}
