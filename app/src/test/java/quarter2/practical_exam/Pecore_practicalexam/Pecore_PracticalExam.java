package quarter2.practical_exam.Pecore_practicalexam;

import java.util.Scanner;

class GymAccess {

    public void start(Scanner scanner) {

        boolean running = true;

        while (running) {

            System.out.println("\n========== GYM ACCESS ==========");
            System.out.println("1. Enter Gym");
            System.out.println("2. Membership Information");
            System.out.println("3. Hire Trainer");
            System.out.println("4. Gym Schedule");
            System.out.println("5. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    enterGym(scanner);
                    break;

                case 2:
                    membershipMenu(scanner);
                    break;

                case 3:
                    trainerMenu(scanner);
                    break;

                case 4:
                    gymSchedule(scanner);
                    break;

                case 5:
                    System.out.println("Exiting Gym System...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    public void enterGym(Scanner scanner) {

        boolean running = true;

        while (running) {

            System.out.println("\n========== ENTER GYM ==========");
            System.out.println("1. Cardio Area");
            System.out.println("2. Weightlifting Area");
            System.out.println("3. Exercise Area");
            System.out.println("4. Return to Main Menu");

            System.out.print("Choose: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("You entered the Cardio Area.");
                    break;

                case 2:
                    System.out.println("You entered the Weightlifting Area.");
                    break;

                case 3:
                    System.out.println("You entered the Exercise Area.");
                    break;

                case 4:
                    System.out.println("Returning to Main Menu...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    public void membershipMenu(Scanner scanner) {

        boolean running = true;

        while (running) {

            System.out.println("\n======= MEMBERSHIP =======");
            System.out.println("1. VIP Membership");
            System.out.println("2. Basic Membership");
            System.out.println("3. Compare Memberships");
            System.out.println("4. Return to Main Menu");

            System.out.print("Choose: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("VIP Membership - Level 1");
                    System.out.println("Trainer Available");
                    break;

                case 2:
                    System.out.println("Basic Membership - Level 2");
                    System.out.println("Trainer Requires Upgrade");
                    break;

                case 3:
                    System.out.println("\nVIP: Level 1 - Trainer Available");
                    System.out.println("Basic: Level 2 - Upgrade Required");
                    break;

                case 4:
                    System.out.println("Returning to Main Menu...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    public void trainerMenu(Scanner scanner) {

        boolean running = true;

        while (running) {

            System.out.println("\n========== TRAINER ==========");
            System.out.println("1. Hire Trainer");
            System.out.println("2. Trainer Information");
            System.out.println("3. Return to Main Menu");

            System.out.print("Choose: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\nEnter Membership Level:");
                    System.out.println("1. VIP");
                    System.out.println("2. Basic");

                    int level = scanner.nextInt();

                    if (level == 1) {
                        System.out.println("Trainer Assigned!");
                    }
                    else if (level == 2) {
                        System.out.println("Upgrade Required.");
                    }
                    else {
                        System.out.println("Invalid Membership Level.");
                    }

                    break;

                case 2:
                    System.out.println("Personal Training");
                    System.out.println("Weight Training");
                    System.out.println("Cardio Training");
                    System.out.println("Strength Training");
                    break;

                case 3:
                    System.out.println("Returning to Main Menu...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    public void gymSchedule(Scanner scanner) {

        boolean running = true;

        while (running) {

            System.out.println("\n========== GYM SCHEDULE ==========");
            System.out.println("1. Monday");
            System.out.println("2. Tuesday");
            System.out.println("3. Wednesday");
            System.out.println("4. Thursday");
            System.out.println("5. Friday");
            System.out.println("6. Saturday");
            System.out.println("7. Sunday");
            System.out.println("8. Return to Main Menu");

            System.out.print("Choose: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Monday: 6 AM - 10 PM");
                    break;

                case 2:
                    System.out.println("Tuesday: 6 AM - 10 PM");
                    break;

                case 3:
                    System.out.println("Wednesday: 6 AM - 10 PM");
                    break;

                case 4:
                    System.out.println("Thursday: 6 AM - 10 PM");
                    break;

                case 5:
                    System.out.println("Friday: 6 AM - 10 PM");
                    break;

                case 6:
                    System.out.println("Saturday: 7 AM - 8 PM");
                    break;

                case 7:
                    System.out.println("Sunday: 8 AM - 6 PM");
                    break;

                case 8:
                    System.out.println("Returning to Main Menu...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
