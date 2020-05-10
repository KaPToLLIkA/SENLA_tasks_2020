package com.tasks.task_1;

import java.util.ArrayList;
import java.util.Collections;

class MyMath {
    public static String oddOrEven(int number) {
        return number % 2 == 0 ? "even" : "odd";
    }

    public static String simpleOrComposite(int number) {
        if(number == 1) {
            return "simple";
        }
        if(number <= 0) {
            return "non-positive";
        }

        boolean insert = false;
        ArrayList<Integer> values = new ArrayList<>(Collections.singletonList(2));

        for(int value = 3; value <= number; value++) {
            insert = true;

            for (Integer valueInList: values) {
                if(value % valueInList == 0)
                {
                    insert = false;
                    break;
                }
            }


            if(insert) {
                values.add(value);
            }
        }
        return number == values.get(values.size() - 1) ? "simple" : "composite";
    }
}