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

            Tokenconfirmation = scanner.nextInt();



        } while (Tokenconfirmation != 4);
    }

    public void claimPrize(Scanner scanner) {

        System.out.println("****** INSERT TICKET AMOUNT ******");
        System.out.print("Insert your ticket: ");
        int Tickets = scanner.nextInt();


    }
}
