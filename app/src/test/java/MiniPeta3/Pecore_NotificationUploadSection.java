package MiniPeta3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Pecore_NotificationUploadSection {

    @Test
    public void NotificationUploadSection() {

        // Simulated user input
        String simulatedInput =
                "Mr.Pecore\n" +
                        "Mathematics\n" +
                        "PETA 3\n" +
                        "Please bring the materials needed for the PETA.\n" +
                        "1 Whole bondpaper and Coloring materials\n" +
                        "September 20, 2026\n";

        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(simulatedInput.getBytes());

        Scanner input = new Scanner(inputStream);

        // Run the notification program
        start(input);

        input.close();
    }

    public void start(Scanner input) {

        // Code for the information placing
        System.out.print("Enter Name: ");
        String name = input.nextLine();

        System.out.print("Subject Name: ");
        String subject = input.nextLine();

        System.out.print("Notification Title: ");
        String title = input.nextLine();

        System.out.print("Notification Context: ");
        String context = input.nextLine();

        System.out.print("Enter a Requirement: ");
        String requirement = input.nextLine();

        System.out.print("Notification Date: ");
        String date = input.nextLine();


        // Where the information will be placed
        System.out.println("\n--- NOTIFICATION INFORMATION --- ");

        System.out.println("Name: " + name);
        System.out.println("Subject: " + subject);
        System.out.println("Title: " + title);
        System.out.println("Context: " + context);
        System.out.println("Requirement: " + requirement);
        System.out.println("Date: " + date);


        // Information displayed on the student's side
        System.out.println("\n--- STUDENT NOTIFICATION ---");

        System.out.println("NOTIFICATION FROM: " + name);
        System.out.println("Subject: " + subject);
        System.out.println("Title: " + title);
        System.out.println("Context: " + context);
        System.out.println("Requirement: " + requirement);
        System.out.println("Date: " + date);
    }
}