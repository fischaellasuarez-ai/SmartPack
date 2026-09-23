package com.example.smartpack.practical_exam;

import java.util.Scanner;
import org.junit.Test;

public class Suarez_PracticalExam {

    @Test

    public void Suarez_PracticalExam() {

        Scanner scanner = new Scanner(System.in);

        {

            System.out.println("###### INSERT YOUR PAYMENT ######");
            System.out.println("Insert Money:");
            int Money = scanner.nextInt();
            System.out.print(Money + " Is now inserted");

            int Token;

            int Tokenconfirmation;

            do {
                //To clear the display
                System.out.print("\033[H\033[2J");
                System.out.flush();

                System.out.println("###### SELECT YOUR AMOUNT OF TOCKEN ######");
                System.out.println("(1) 100 Pesos");
                System.out.println("(2) 200 Pesos");
                System.out.println("(3) 300 Pesos");
                System.out.println("(4) EXIT");
                System.out.print("SELECT A NUMBER: ");

                // Validate that input is an integer
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    return;
                }

                Tokenconfirmation = scanner.nextInt();

                // 100 PESOS
                if (Tokenconfirmation == 1) {

                    if (Money < 100) {
                        System.out.println("Insufficient payment.");
                        return;
                    }

                    int change = Money - 100;

                    do {
                        //To clear the display
                        System.out.print("\033[H\033[2J");
                        System.out.flush();

                        System.out.println("***** ARE YOU SURE? *****");
                        System.out.println("100 PESOS - 50 TOKEN");
                        System.out.println("(1)CONFIRM");
                        System.out.println("(2)GO BACK");
                        System.out.println("(3)EXIT");
                        System.out.print("SELECT A NUMBER:");

                        Token = scanner.nextInt();

                        if (Token == 1) {
                            System.out.print("\033[H\033[2J");
                            System.out.flush();

                            System.out.println("50 Tokens received!");
                            System.out.println("Change: " + change + " Pesos");
                            System.out.println("Press Enter to continue...");

                            scanner.nextLine();
                            scanner.nextLine();

                            return;
                        }

                        if (Token == 3) {
                            System.out.println("Exit");
                            return;
                        }

                    } while (Token != 1 &&
                            Token != 2 &&
                            Token != 3);
                }

                // 200 PESOS
                else if (Tokenconfirmation == 2) {

                    if (Money < 200) {
                        System.out.println("Insufficient payment.");
                        return;
                    }

                    int change = Money - 200;

                    do {
                        //To clear the display
                        System.out.print("\033[H\033[2J");
                        System.out.flush();

                        System.out.println("***** ARE YOU SURE? *****");
                        System.out.println("200 PESOS - 100 TOKEN");
                        System.out.println("(1)CONFIRM");
                        System.out.println("(2)GO BACK");
                        System.out.println("(3)EXIT");
                        System.out.print("SELECT A NUMBER:");

                        Token = scanner.nextInt();

                        if (Token == 1) {
                            System.out.print("\033[H\033[2J");
                            System.out.flush();

                            System.out.println("100 Tokens received!");
                            System.out.println("Change: " + change + " Pesos");
                            System.out.println("Press Enter to continue...");

                            scanner.nextLine();
                            scanner.nextLine();

                            return;
                        }

                        if (Token == 3) {
                            System.out.println("Exit");
                            return;
                        }

                    } while (Token != 1 &&
                            Token != 2 &&
                            Token != 3);
                }

                // 300 PESOS
                else if (Tokenconfirmation == 3) {

                    if (Money < 300) {
                        System.out.println("Insufficient payment.");
                        return;
                    }

                    int change = Money - 300;

                    do {
                        //To clear the display
                        System.out.print("\033[H\033[2J");
                        System.out.flush();

                        System.out.println("***** ARE YOU SURE? *****");
                        System.out.println("300 PESOS - 150 TOKEN");
                        System.out.println("(1)CONFIRM");
                        System.out.println("(2)GO BACK");
                        System.out.println("(3)EXIT");
                        System.out.print("SELECT A NUMBER:");

                        Token = scanner.nextInt();

                        if (Token == 1) {
                            System.out.print("\033[H\033[2J");
                            System.out.flush();

                            System.out.println("150 Tokens received!");
                            System.out.println("Change: " + change + " Pesos");
                            System.out.println("Press Enter to continue...");

                            scanner.nextLine();
                            scanner.nextLine();

                            return;
                        }

                        if (Token == 3) {
                            System.out.println("Exit");
                            return;
                        }

                    } while (Token != 1 &&
                            Token != 2 &&
                            Token != 3);
                }

                else if (Tokenconfirmation == 4) {
                    System.out.println("Exit");
                }

                else if (Tokenconfirmation != 1 &&
                        Tokenconfirmation != 2 &&
                        Tokenconfirmation != 3 &&
                        Tokenconfirmation != 4) {
                    System.out.println("Invalid choice.");
                }

            } while (Tokenconfirmation != 4);

            scanner.close();
        }
    }
}
