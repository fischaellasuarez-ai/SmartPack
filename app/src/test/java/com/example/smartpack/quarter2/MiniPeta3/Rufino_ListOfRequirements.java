package com.example.smartpack.quarter2.MiniPeta3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Rufino_ListOfRequirements {

    @Test
    public void ListOfRequirments() {

        // Simulated user input
        String simulatedInput =
                "Computer Programming\n" +
                        "3\n" +
                        "Java Activity\n" +
                        "Programming Exercise\n" +
                        "Mini Project\n";

        // Convert the input into a stream
        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(
                        simulatedInput.getBytes()
                );

        Scanner scanner =
                new Scanner(inputStream);

        System.out.println(
                "==- SMARTPACK: LIST OF REQUIREMENTS ==="
        );

        System.out.print("Enter subject: ");
        String subject = scanner.nextLine();

        System.out.print("Enter number of requirements:  ");
        int number = scanner.nextInt();
        scanner.nextLine();

        String[] requirements =
                new String[number];

        for (int i = 0; i < number; i++) {

            System.out.print(
                    "Enter requirement " + (i + 1) + ": "
            );

            requirements[i] =
                    scanner.nextLine();
        }

        System.out.println(
                "\n=== REQUIREMENTS FOR " + subject + " ==="
        );

        for (int i = 0; i < number; i++) {

            System.out.println(
                    (i + 1) + ". " + requirements[i]
            );
        }

        scanner.close();
    }
}