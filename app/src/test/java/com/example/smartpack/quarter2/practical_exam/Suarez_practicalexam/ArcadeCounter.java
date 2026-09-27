package com.example.smartpack.quarter2.practical_exam.Suarez_practicalexam;

import java.util.Scanner;

public class ArcadeCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new ArcadeCounter().start(scanner);
    }

    public void start(Scanner scanner) {
        buyTokens(scanner);
        claimPrize(scanner);
    }

    public void buyTokens(Scanner scanner) {

        System.out.println("###### INSERT YOUR PAYMENT ######");
        System.out.println("Insert Money:");
        int Money = scanner.nextInt();
        System.out.print(Money + " Is now inserted");

        int Tokenconfirmation;

        do {
            System.out.println("###### SELECT YOUR AMOUNT OF TOCKEN ######");
            System.out.println("(1) 100 Pesos");
            System.out.println("(2) 200 Pesos");
            System.out.println("(3) 300 Pesos");
            System.out.println("(4) EXIT");
            System.out.print("SELECT A NUMBER: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                return;
            }

            Tokenconfirmation = scanner.nextInt();

            if (Tokenconfirmation == 1) {

            } else if (Tokenconfirmation == 2) {

            } else if (Tokenconfirmation == 3) {

            } else if (Tokenconfirmation == 4) {
                System.out.println("Exit");
            } else {
                System.out.println("Invalid choice.");
            }

        } while (Tokenconfirmation != 4);
    }

    public void claimPrize(Scanner scanner) {

        System.out.println("****** INSERT TICKET AMOUNT ******");
        System.out.print("Insert your ticket: ");
        int Tickets = scanner.nextInt();

        if (Tickets < 500) {
            System.out.println("You don't have enought ticket, Please keep playing!");
            return;
        } else {
            System.out.println(" ###### CHOOSE YOUR DESIRED PRIZE.###### ");
        }

        System.out.println();
        System.out.println("****** SELECT YOUR PRIZE ******");
        System.out.println("(1) PLUSHY     - 500 TICKETS");
        System.out.println("(2) TEDDY BEAR - 800 TICKETS");
        System.out.println("(3) RC CAR     - 1000 TICKETS");
        System.out.println("(4) EXIT");
        System.out.print("Choose: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                //input
                break;
            case 2:
                //input
                break;
            case 3:
                //input
                break;
            case 4:
                System.out.println("Exit");
                return;
            default:
                System.out.println("Invalid choice.");
                return;
        }
    }
}
