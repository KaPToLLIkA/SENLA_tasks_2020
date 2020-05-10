package com.tasks.task_2;

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