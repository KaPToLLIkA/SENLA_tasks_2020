package com.tasks.task_1;


import java.util.*;

public class Main {
    public static void main(String[] args) {

        int inputValue = Integer.MAX_VALUE;
        Scanner input = new Scanner(System.in);


        while (inputValue != 0) {
            while (true) {
                System.out.print("Enter an integer or zero to exit: ");
                try{
                    inputValue = input.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Error");
                    input.nextLine();
                }
            }

            System.out.printf("%d is %s.\n", inputValue, MyMath.oddOrEven(inputValue));
            System.out.printf("%d is %s.\n", inputValue, MyMath.simpleOrComposite(inputValue));
        }


    }
}
