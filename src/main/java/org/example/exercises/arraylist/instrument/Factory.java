package org.example.exercises.arraylist.instrument;

import java.util.ArrayList;

public class Factory {

	private ArrayList<Office> offices;

	public Factory() {
		this.offices = new ArrayList<>();
	}
	
	public void addOffice(Office office) {
		this.offices.add(office);
	}
	
	public void listInstruments() {
		for (Office offi : offices) {
			System.out.println(offi.getName());
			offi.listInstruments();
		}
	}
		
	public ArrayList<Instrument> instrumentByType(TypeInstrument type) {
		ArrayList<Instrument> instFound = new ArrayList<>();
		for (Office offi : offices) {
			instFound.addAll(offi.instrumentByType(type));			
		}

		return instFound;
	}
	
	public Instrument deleteInstrument(String id) {
		Instrument deleted = null;
		for (Office office : offices) {
	        deleted = office.deleteInstrument(id);
	        if (deleted != null) {
	            return deleted;
	        }
	    }
		return deleted;
	}
	
	public double[] percInstrumentsByType(String officeName) {
		double[] percentages = null;
		Office officeFound = findOffice(officeName);
		if(officeFound != null) {
			percentages = officeFound.percInstrumentsByType();
		}
		
		return percentages;
	}
	
	private Office findOffice(String officeName) {
		Office officeFound = null;
		
		for ( Office offi: offices) {
			if(offi.getName().equals(officeName)) {
				officeFound = offi;
				break;
			}
		}
		
		return officeFound;		
	}
	
}
