package org.example.projects.average;

import java.util.ArrayList;
import java.util.List;

public class Distributor {

	private String name;
	private List<Car> cars;

	public Distributor(String name) {
		this.setName(name);
		this.cars = new ArrayList<>();
	}

	public void addCar(Car c) {
		this.cars.add(c);
	}

	public int sumKm() {
		//int total = 0;
		
		/*for(Car ca : cars) {
			total += ca.getMileage();
		}
				
		return cars.stream()
                .mapToInt(Car::getMileage)
                .sum();*/
		
		return cars.stream()
				.mapToInt(car -> car.getMileage())
				.sum();
		
		//return total;
	}
	
	public int totalCars() {
		return cars.size();
	}

	public double averageDistance() {
		/*double average = 0;
		if (totalCars() > 0) {
			average = (double) sumKm() / totalCars();
		}
		return average;*/
		
		return (totalCars() > 0 ? (double) sumKm() / totalCars() : 0);
	}

	public void showCars() {
		for (Car c : cars) {
			System.out.println("The model car is " + c.getModelId());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
