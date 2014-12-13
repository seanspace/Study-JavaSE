package com.bin.objectriended;

public class Circle {
	private double radius ;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double findArea(){
		return 3.14 * radius * radius ;
	}

}
