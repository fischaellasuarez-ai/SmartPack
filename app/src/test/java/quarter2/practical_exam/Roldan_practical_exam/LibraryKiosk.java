package quarter2.practical_exam.Roldan_practical_exam;

import java.util.Scanner;

public class LibraryKiosk {

    public void start(Scanner scanner) {

        double fine = 15;
        int choice;

        do {
            System.out.println("~~~ LIBRARY KIOSK  ~~~");
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
                System.out.println("Fine: " + fine);
                System.out.print("Enter payment: ");

                double payment = scanner.nextDouble();

                if (payment < fine) {

                    System.out.println("Insufficient payment.");

                } else {

                    System.out.println("Payment successful!");
                    System.out.println("Change: " + (payment - fine));

                    fine = 0;
                }

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