import java.util.Scanner;

public class FastFoodTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("=== FAST FOOD MENU ===");
        System.out.println("1. Burger - ₱50");
        System.out.println("2. Fries - ₱30");
        System.out.println("3. Chicken - ₱80");
        System.out.println("4. Soft Drink - ₱25");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        double price = 0;
        String item = "";

        switch (choice) {
            case 1:
                item = "Burger";
                price = 50;
                break;
            case 2:
                item = "Fries";
                price = 30;
                break;
            case 3:
                item = "Chicken";
                price = 80;
                break;
            case 4:
                item = "Soft Drink";
                price = 25;
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }



    }
}