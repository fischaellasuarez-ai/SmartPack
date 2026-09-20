package com.example.smartpack.quarter2.MiniPeta3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Roldan_DeliverRequirment {

    // The delivering of requirements
    @Test
    public void DeliverRequirment() {

        // Simulated user input
        String simulatedInput =
                "18\n" +
                        "9\n" +
                        "2026\n" +
                        "Ms.Roldan\n" +
                        "11\n" +
                        "St.Isidore of Seville\n" +
                        "yes\n";

        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(simulatedInput.getBytes());

        Scanner input = new Scanner(inputStream);

        System.out.print("Enter Date Day: ");
        int day = input.nextInt();

        System.out.print("Enter Date Month: ");
        int month = input.nextInt();

        System.out.print("Enter Date Year: ");
        int year = input.nextInt();

        input.nextLine(); // Clear leftover Enter

        System.out.print("Enter Teacher Name: ");
        String teacherName = input.nextLine();

        System.out.print("Enter Target Grade: ");
        int targetGrade = input.nextInt();

        input.nextLine(); // Clear leftover Enter

        System.out.print("Enter Target Section: ");
        String targetSection = input.nextLine();

        System.out.print("Was the notification sent? (yes/no): ");
        String answer = input.nextLine();

        boolean notificationSent;

        if (answer.equalsIgnoreCase("yes")) {
            notificationSent = true;
        } else {
            notificationSent = false;
        }

        // Display information
        System.out.println("\n--- NOTIFICATION --- ");
        System.out.println("Upload Date: " + day + "/" + month + "/" + year);
        System.out.println("Teacher Name: " + teacherName);
        System.out.println("Target Grade: " + targetGrade);
        System.out.println("Target Section: " + targetSection);
        System.out.println("Notification Sent: " + notificationSent);

        input.close();
    }
}