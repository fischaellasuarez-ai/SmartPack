package quarter2.practical_exam.Suarez_practical_exam;

import java.util.Scanner;

public class ArcadeCounter {

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

    private void PurchasingOfToken() {
    }

    private void ClaimYourPrize(Scanner scanner) {
    }
}

