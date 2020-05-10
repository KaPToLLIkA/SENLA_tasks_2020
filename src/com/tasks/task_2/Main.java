package com.tasks.task_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(true) {
            int firstValue = getIntFromInput(input, "Print first value or zero to exit: ");
            if(firstValue == 0) break;
            int secondValue = getIntFromInput(input, "Print second value or zero to exit: ");
            if(secondValue == 0) break;

            System.out.printf("%d - greatest common divisor\n", MyMath.getGreatestDivisor(firstValue, secondValue));
            System.out.printf("%d - smallest common multiple\n", MyMath.getSmallestMultiple(firstValue, secondValue));

        }


    }

    private static int getIntFromInput(Scanner input, String message) {
        while (true) {
            System.out.print(message);
            try{
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error");
                input.nextLine();
            }
        }
    }
}


class MyMath {
    public static int getGreatestDivisor(int firstNumber, int secondNumber) {
        int max = Integer.max(firstNumber, secondNumber),
                min = Integer.min(firstNumber, secondNumber);

        while(max - min != 0) {
            min = Integer.min(max - min, min);
            max = Integer.max(max - min, min);
        }

        return max;
    }

    public static int getSmallestMultiple(int firstNumber, int secondNumber) {
        return (firstNumber * secondNumber) / getGreatestDivisor(firstNumber, secondNumber);
    }

}
