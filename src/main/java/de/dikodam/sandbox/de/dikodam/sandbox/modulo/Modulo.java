package de.dikodam.sandbox.de.dikodam.sandbox.modulo;

public class Modulo {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int sum = 0;
        int size = array.length;

        for (int i = 0; i < 10; i++) {
            sum += array[i % size];
        }
        System.out.println("Summe (30): " + sum);

        for (int i = 3; i < 10; i++) {
            sum += array[i % size];
        }
        System.out.println("Summe (24): " + sum);


        for (int i = -10; i < 11; i++) {
            System.out.println(String.format("%d mod %d ist %d", i, size, i % size));
            System.out.println(String.format("%d Math.floorMod %d ist %d", i, size, Math.floorMod(i, size)));

        }

//        for (int i = 4; i >= -5 ; i--) {
//            sum += array[i % size];
//        }
//        System.out.println("Summe (24): " + sum);
    }
}
