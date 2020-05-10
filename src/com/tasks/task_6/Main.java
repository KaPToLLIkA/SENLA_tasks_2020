package com.tasks.task_6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Cargo inputItems = new Cargo();

        int itemsCount = getIntFromInput(input, "Print N: ");

        Backpack backpack = new Backpack(getDoubleFromInput(input, "Print max weight: "));

        for(int i = 0; i < itemsCount; i++) {
            System.out.println(i + 1);
            inputItems.addItem(
                    new Item(
                            getDoubleFromInput(input, "Print weight: "),
                            getDoubleFromInput(input, "Print cost: ")
                    )
            );
        }

        backpack.loadingItems(inputItems);
        System.out.printf("Max cost: %f", backpack.getCost());
        System.out.println(backpack.getLoadedItems().toString());
    }

    private static int getIntFromInput(Scanner input, String message) {
        while (true) {
            System.out.print(message);
            try{
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error\n");
                input.nextLine();
            }
        }
    }

    private static double getDoubleFromInput(Scanner input, String message) {
        while (true) {
            System.out.print(message);
            try{
                return input.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Error\n");
                input.nextLine();
            }
        }
    }


}

