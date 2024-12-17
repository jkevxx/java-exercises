package org.example.exercises.binary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {

//		int num = 8;
//		String binaryNumber = Integer.toBinaryString(num);

//		System.out.println("binary => " + binaryNumber);
//		System.out.println("lenght => " + binaryNumber.length());

		mystery(6);

	}

	public static long mystery(long n) {
		int num = Math.toIntExact(n);
		String binaryNumber = Integer.toBinaryString(num);
		ArrayList<String> arrList = new ArrayList<>();
		arrList.add("0");
		arrList.add("1");

		if (binaryNumber.length() == 1) {
			System.out.println("binary array position: " + arrList.get(num));
			int decimal = Integer.parseInt(arrList.get(num), 2);
			System.out.println("decimal number: " + decimal);
		}
		
		ArrayList<String> arrList2 = (ArrayList<String>) arrList.clone();
		Collections.reverse(arrList2);
		
		for (int i = 0; i < arrList.size(); i++) {
			arrList.set(i, ("0" + arrList.get(i)));
			arrList2.set(i, ("1" + arrList2.get(i)));
		}
		arrList.addAll(arrList2);
		
		if (binaryNumber.length() == 2) {
			System.out.println(arrList);
			String binaryPosition = arrList.get(num);
			System.out.println("binary => " + binaryPosition);
			System.out.println("number => " + Integer.parseInt(binaryPosition, 2));			
		}
		
		ArrayList<String> arrList3 = (ArrayList<String>) arrList.clone();
		Collections.reverse(arrList3);
		
		for (int i = 0; i < arrList.size(); i++) {
			arrList.set(i, ("0" + arrList.get(i)));
			arrList3.set(i, ("1" + arrList3.get(i)));
		}
		arrList.addAll(arrList3);
		
		if (binaryNumber.length() == 3) {
			System.out.println(arrList);
			String binaryPosition = arrList.get(num);
			System.out.println("binary => " + binaryPosition);
			System.out.println("number => " + Integer.parseInt(binaryPosition, 2));	
		}
//		System.out.println(binaryNumber.length());
//		System.out.println(arrList);


		return -1;
	}
	
	public static ArrayList<String> getBinaryArray(ArrayList<String> arr){
		
		return new ArrayList<>();
	}
}
