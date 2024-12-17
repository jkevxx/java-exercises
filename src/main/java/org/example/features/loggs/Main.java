package org.example.features.loggs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	static final Logger logJava = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		logJava.info("Log info for this item");
		
		System.out.println("hi");
		
	}

}
