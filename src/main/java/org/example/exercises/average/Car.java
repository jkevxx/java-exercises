package org.example.projects.average;

public class Car {

	private String modelId;
	private String color;
	private int mileage;
	
	public Car(String modelId, String color, int mileage) {
		this.modelId = modelId;
		this.color = color;
		this.mileage = mileage;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	
	
}
