package org.example.exercises.arraylist.instrument;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Factory fac = new Factory();
		loadFactory(fac);
		//fac.listInstruments();
		/*ArrayList<Instrument> list = fac.instrumentByType(TypeInstrument.PERCUSSION);
		
		for (Instrument instru : list) {
			System.out.println(instru);
		}*/
		
		//fac.deleteInstrument("2-ab-c");
		double[] perc =  fac.percInstrumentsByType("Office B");
		
		for (int i = 0; i< perc.length; i++) {
			System.out.println(perc[i]);
		}
		

	}

	public static void loadFactory(Factory fac) {
		Office off1 = new Office("Office A");
		Office off2 = new Office("Office B");

		off1.addInstrument(new Instrument("1-ab-c", 99.5, TypeInstrument.STRING));
		off1.addInstrument(new Instrument("2-ab-c", 89.0, TypeInstrument.STRING));
		off1.addInstrument(new Instrument("3-ab-c", 79.0, TypeInstrument.PERCUSSION));

		off2.addInstrument(new Instrument("1-xy-z", 108.0, TypeInstrument.WOODWIND));
		off2.addInstrument(new Instrument("2-xy-z", 155.0, TypeInstrument.PERCUSSION));
		
		fac.addOffice(off1);
		fac.addOffice(off2);
	}

}
