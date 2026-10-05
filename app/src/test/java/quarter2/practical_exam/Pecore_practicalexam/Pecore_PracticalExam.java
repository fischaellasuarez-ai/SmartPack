import java.util.Scanner;

class GymAccess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new GymAccess().start(scanner);
    }

    public void start(Scanner scanner) {
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
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public void enterGym(Scanner scanner) {
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
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // Dummy methods added to ensure the code compiles cleanly
    public void membershipMenu(Scanner scanner) {
        System.out.println("Opening Membership Information...");
    }

    public void trainerMenu(Scanner scanner) {
        System.out.println("Opening Trainer Menu...");
    }

    public void gymSchedule(Scanner scanner) {
        System.out.println("Opening Gym Schedule.");
    }
}