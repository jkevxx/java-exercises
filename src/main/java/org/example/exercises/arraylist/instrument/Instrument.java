package org.example.exercises.arraylist.instrument;

public class Instrument {
	private String ID;
	private double price;
	private TypeInstrument type;

	public Instrument(String ID, double price, TypeInstrument type) {
		this.ID = ID;
		this.price = price;
		this.type = type;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public TypeInstrument getType() {
		return type;
	}

	public void setType(TypeInstrument type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Instrument [ID=" + ID + ", price=" + price + ", type=" + type + "]";
	}

}
