package com.tasks.task_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.print("Print text or \"exit\" to exit: ");
            String text = input.nextLine();
            if(text.equals("exit")) break;

            System.out.print("Print word or \"exit\" to exit: ");
            String searchWord = input.nextLine();
            if(searchWord.equals("exit")) break;

            text = text.replaceAll("[,.!?\\-:;\"\']", "");

            ArrayList<String> words = new ArrayList<>(Arrays.asList(text.split("\\s")));
            words.removeAll(Collections.singleton(""));

            int count = 0;
            for (String word: words)
                if(word.compareToIgnoreCase(searchWord) == 0)
                    ++count;

            System.out.printf("%d words found\n", count);
        }
    }
}
