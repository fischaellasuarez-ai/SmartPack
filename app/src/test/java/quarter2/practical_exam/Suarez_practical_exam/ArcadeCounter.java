package quarter2.practical_exam.Suarez_practical_exam;

import java.util.Scanner;

public class ArcadeCounter {

    // The Main system of the code  and menu loop
    public void start(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("\n <<<< ARCADE MENU >>>>");
            System.out.println("SELECT AN OPTION:");
            System.out.println("OPTION 1. Buy Tokens");
            System.out.println("OPTION 2. Collect your prize");
            System.out.println("OPTION 3. Exit");
            System.out.println();

            if (!scanner.hasNextInt()) {
                break;
            }

            int mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    PurchasingOfToken();
                    break;

                case 2:
                    ClaimYourPrize(scanner);
                    break;

                case 3:
                    System.out.println("Thank you for playing! Please come again!");
                    System.out.println();
                    running = false;
                    break;

                default:
                    System.out.println("Your choice is invalid. Please try again.");
                    break;
            }
        }
    }

    // Where buying of tokens happen
    private void PurchasingOfToken() {
        System.out.println("*** OPTION 1 ***");
        System.out.println("\nYou have selected OPTION (1): Buy Tokens");
        System.out.println("Tokens are now successfully purchased!");
    }

    // Where the claiming of prize happen
    private void ClaimYourPrize(Scanner scanner) {
        int requiredTickets = 500;
        System.out.println("*** OPTION 2 ***");
        System.out.println("You have selected OPTION (2): Collect your prize ");
        System.out.println("Required tickets for Teddy Bear: " + requiredTickets);
        System.out.print("Please insert your ticket amount: ");

        if (scanner.hasNextInt()) {
            int tickets = scanner.nextInt();

            System.out.println();
            if (tickets < requiredTickets) {
                System.out.println("\n###### PLEASE KEEP PLAYING TO ACHIEVE YOUR PRIZE! ######");

            } else {
                System.out.println("\n###### HERE IS YOUR PRIZE######");
                System.out.println();
                System.out.println("         *$* TEDDY BEAR *$*      ");
                System.out.println("        !!!CONGRATULATION!!!     ");
            }
        } else {
            System.out.println("Ticket invalid count.");
            scanner.next();
        }
    }
}

