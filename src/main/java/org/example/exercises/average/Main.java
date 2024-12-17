package org.example.projects.average;

public class Main {

	public static void main(String[] args) {

		Distributor dis = new Distributor("stark");
		
		dis.addCar(new Car("ABC12", "Red", 1003));
		dis.addCar(new Car("DEF34", "Blue", 2000));
		dis.addCar(new Car("GHI56", "Black", 3000));
		dis.addCar(new Car("JKL56", "Black", 4000));
		
		System.out.println("Kms total distance: " + dis.sumKm());
		System.out.println("Cars amount: " + dis.totalCars());

		System.out.println("Average: " + dis.averageDistance());

	}

}
