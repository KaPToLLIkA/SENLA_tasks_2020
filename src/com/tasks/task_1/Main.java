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


class MyMath {
    public static String oddOrEven(int number) {
        return number % 2 == 0 ? "even" : "odd";
    }

    public static String simpleOrComposite(int number) {
        if(number == 1) return "simple";
        if(number <= 0) return "non-positive";

        boolean insert = false;
        ArrayList<Integer> values = new ArrayList<>(Collections.singletonList(2));

        for(int value = 3; value <= number; ++value) {
            insert = true;
            for (Integer valueInList: values)
                if(value % valueInList == 0)
                {
                    insert = false;
                    break;
                }

            if(insert) values.add(value);
        }
        return number == values.get(values.size() - 1) ? "simple" : "composite";
    }
}