package org.example.exercises.arraylist.instrument;

import java.util.ArrayList;

public class Office {

	private String name;
	private ArrayList<Instrument> instruments;

	public Office(String name) {
		this.name = name;
		this.instruments = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addInstrument(Instrument instru) {
		this.instruments.add(instru);
	}

	public void listInstruments() {
		for (Instrument instru : instruments) {
			System.out.println(instru);
		}
	}

	public ArrayList<Instrument> instrumentByType(TypeInstrument type) {
		ArrayList<Instrument> instFound = new ArrayList<>();

		for (Instrument instru : instruments) {
			if (instru.getType() == type) {
				instFound.add(instru);
			}
		}

		return instFound;
	}
	
	public Instrument deleteInstrument(String id) {
		Instrument instruDeleted = findInstrument(id);
		this.instruments.remove(instruDeleted);
		
		return instruDeleted;
	}
	
	private Instrument findInstrument(String ID) {
		Instrument instruFound = null;
		
		for ( Instrument instru: instruments) {
			if(instru.getID().equals(ID)) {
				instruFound = instru;
				break;
			}
		}
		
		return instruFound;		
	}
	
	public double[] percInstrumentsByType() {
		final int INSTRUMENTS_COUNT = TypeInstrument.values().length;
		double[] percentages = new double[INSTRUMENTS_COUNT];
		for (Instrument instru :  instruments) {
			percentages[instru.getType().ordinal()]++;
		}
		absolutePercentage(percentages);
		return percentages;
	}
	
	private void absolutePercentage(double[] percentages) {
		for (int i = 0; i < percentages.length; i++) {
			percentages[i] = (percentages[i] * 100) / instruments.size();	
		}
		
	}

}
