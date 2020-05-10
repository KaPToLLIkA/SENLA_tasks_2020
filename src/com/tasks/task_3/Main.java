package com.tasks.task_3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Print text or \"exit\" to exit: ");

            String text = input.nextLine();
            if(text.equals("exit")) {
                break;
            }

            text = text.replaceAll("[,.!?\\-:;\"\']", "");

            ArrayList<String> words = new ArrayList<>(Arrays.asList(text.split("\\s")));
            words.removeAll(Collections.singleton(""));


            boolean skipped = false;
            while(!skipped) {
                System.out.println(
                                "1) Print the number of words\n" +
                                "2) Sort the words\n" +
                                "3) Make the first letter capitalized in each word\n" +
                                "0) Skip\n"
                );

                switch (input.nextLine()) {
                    case "1":
                        System.out.printf("The number of words: %d\n", words.size());
                        break;


                    case "2":
                        words.sort(String::compareToIgnoreCase);
                        System.out.println(words.toString());
                        break;


                    case "3":
                        for (int i = 0; i < words.size(); i++) {
                            words.set(i, words.get(i).substring(0, 1).toUpperCase() + words.get(i).substring(1));
                        }
                        System.out.println(words.toString());
                        break;


                    case "0":
                        skipped = true;
                        break;


                    default:
                        System.out.println("Wrong command");
                        break;
                }
            }
        }
    }
}
