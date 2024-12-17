package org.example.exercises.binary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Binary {
	private static final int MIN_BINARY_LENGTH = 1;
	private static final int INVALID_INDEX = -1;

	public static long mystery(long n) {
		int maxLength = Long.toBinaryString(n).length();
		int num = Math.toIntExact(n);
		List<String> binarySequence = generateBinarySequence(maxLength);
		String binaryPosition = binarySequence.get(num);

		return Integer.parseInt(binaryPosition, 2);
	}

	public static long mysteryInv(long n) {
		String binaryRepresentation = Long.toBinaryString(n);
		List<String> binarySequence = generateBinarySequence(binaryRepresentation.length());
		int index = binarySequence.indexOf(binaryRepresentation);
		return (index == INVALID_INDEX || index == binarySequence.size() - 1) ? -1 : index;
	}

	public static String nameOfMystery() {
		return "Mystery Function";
	}

	public static List<String> generateBinarySequence(int length) {
		if (length < MIN_BINARY_LENGTH) {
			throw new IllegalArgumentException("Binary length must be at least 1.");
		}

		List<String> binaryStrings = new ArrayList<>();
		binaryStrings.add("0");
		binaryStrings.add("1");

		for (int i = 1; i < length; i++) {
			List<String> reversedList = new ArrayList<>(binaryStrings);
			Collections.reverse(reversedList);

			for (int j = 0; j < binaryStrings.size(); j++) {
				binaryStrings.set(j, "0" + binaryStrings.get(j));
				reversedList.set(j, "1" + reversedList.get(j));
			}
			binaryStrings.addAll(reversedList);
		}
		return binaryStrings;
	}

	public static void main(String[] args) {
		long inputNumber = 6;
		long inputNumber2 = 5;

		System.out.println(mystery(inputNumber));
		System.out.println(mysteryInv(inputNumber2));

	}

}
