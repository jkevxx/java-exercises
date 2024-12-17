package org.example;

public class Main {

    public static void main(String[] args) {

        String myName = "Kevin";
        String myName2 = myName;

        myName = "Oliver";
        System.out.println(myName2);

//        System.out.println(myName2 == myName);
        int row= 5;
        int colum = 6;
        int[][] myMatrix = new int[row][colum];


        int aux = 2;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                if (j % 2 == 0) {
                    myMatrix[i][j] = aux;
                    aux += 2;
                } else {
                    myMatrix[i][j] = 0;
                }
            }

        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                System.out.print(myMatrix[i][j] + "\t");
            }
            System.out.println();
        }

    }
}

