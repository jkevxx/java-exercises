package org.example.exercises.increasing;

public class ArrayIncreasing {

    public static boolean canBeIncreasing(int[] arrayNum) {
        int[] newArrayNum = new int[arrayNum.length - 1];

        int arrayPosition = 0;

        while (arrayPosition < arrayNum.length) {
            int isIncreasing = 0;

            for (int i = 0, j = 0; i < arrayNum.length; i++) {
                if (i != arrayPosition) {
                    newArrayNum[j] = arrayNum[i];
                    j++;
                }
            }

            for (int i = 0; i < newArrayNum.length; i++) {
                System.out.print(newArrayNum[i] + " ");
            }

            int arrayNumLength = newArrayNum.length - 1;

            for (int i = 0, j = 0; i < arrayNumLength; i++, j++) {
                if (newArrayNum[i] < newArrayNum[j + 1]) {
                    isIncreasing++;
                }
            }

            System.out.println();
            if (isIncreasing == arrayNumLength) {
                System.out.println("it's increasing: " + isIncreasing);
                return true;
            }

            arrayPosition++;
        }


        return false;
    }

    public static void main(String[] args) {

//        int[] nums = {2,12,3};

        boolean isIncreasing = canBeIncreasing(new int[]{2, 3, 4, 8, 6});
        System.out.println(isIncreasing);
    }
}

