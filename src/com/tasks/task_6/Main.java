package com.tasks.task_6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Task.N = getIntFromInput(input, "Print N: ");
        Task.maxWeight = getDoubleFromInput(input, "Print max weight: ");


        for(int i = 0; i < Task.N; ++i) {
            System.out.println(i+1);
            Task.weights.add(getDoubleFromInput(input, "Print weight: "));
            Task.costs.add(getDoubleFromInput(input, "Print cost: "));
        }


        Task.recTask(0, 0, 0);
        Task.maxTotalCosts.sort(Double::compareTo);
        System.out.printf("Max cost: %f", Task.maxTotalCosts.get(Task.maxTotalCosts.size() - 1));

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

class Task {
    static ArrayList<Double> maxTotalCosts = new ArrayList<>();
    static ArrayList<Double> weights = new ArrayList<>();
    static ArrayList<Double> costs = new ArrayList<>();
    static int N = 0;
    static double maxWeight = Double.MAX_VALUE;

    public static void recTask(double curWeight, double curCost, int curIndex) {
        for(int i = curIndex; i < N; ++i) {
            double newWeight = curWeight + weights.get(i);
            double newCost = curCost + costs.get(i);

            if(newWeight <= maxWeight) {
                maxTotalCosts.add(newCost);
                if(i + 1 != N)
                    recTask(newWeight, newCost, i + 1);
            }
        }
    }
}

