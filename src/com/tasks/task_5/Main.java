package com.tasks.task_5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder builder;
        Scanner input = new Scanner(System.in);

        int N;
        while (true) {
            System.out.print("Print N: ");
            try{
                N = input.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error");
                input.nextLine();
            }
        }

        for(int value = 0; value <= N; ++value) {
            builder = new StringBuilder(Integer.toString(value));

            if(builder.toString().equals(builder.reverse().toString()))
                System.out.printf("%d - palindrome\n", value);
        }
    }
}
