package com.example.smartpack.practical_exam;

import java.util.Scanner;

public class Roldan_PracticalExam {

    public void start(Scanner scanner) {

        int choice;

        do {
            System.out.println("~~~ LIBRARY KIOSK ~~~");
            System.out.println("1. Borrow Book");
            System.out.println("2. Pay Fines");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            choice = scanner.nextInt();

            if (choice == 1) {

                System.out.println("Book borrowed successfully!");

            } else if (choice == 2) {

                System.out.println("Pay Fines");

            } else if (choice == 3) {

                System.out.println(
                        "Thank you for using the Library Kiosk! Goodbye."
                );

            } else {

                System.out.println("Invalid choice.");

            }

        } while (choice != 3);
    }
}