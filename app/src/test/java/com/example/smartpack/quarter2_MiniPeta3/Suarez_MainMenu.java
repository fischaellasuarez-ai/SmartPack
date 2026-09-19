package com.example.smartpack.quarter2_MiniPeta3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Suarez_MainMenu {

    // ==============================
    // 1. NOTIFICATION UPLOAD
    // ==============================
    @Test
    public void MainMenu() {

        String simulatedInput =
                "Math\n" +
                        "1 whiteboard\n";

        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(simulatedInput.getBytes());

        Scanner input = new Scanner(inputStream);

        System.out.println("\n==============================");
        System.out.println("NOTIFICATION UPLOAD");
        System.out.println("==============================");

        notificationUpload(input);

        input.close();
    }

    public void notificationUpload(Scanner input) {

        String subject;
        String requirement;

        System.out.print("Enter Subject: ");
        subject = input.nextLine();

        System.out.print("Enter Requirement: ");
        requirement = input.nextLine();

        if (subject.isEmpty() || requirement.isEmpty()) {

            System.out.println("Upload Failed");
            System.out.println("Subject or Requirement is empty.");

        } else {

            System.out.println("Requirement Uploaded Successfully");
            System.out.println("------------------------------");
            System.out.println("Subject: " + subject);
            System.out.println("Requirement: " + requirement);
        }
    }


    // ==============================
    // 2. DELIVER REQUIREMENT
    // ==============================
    @Test
    public void testDeliverRequirement() {

        String simulatedInput =
                "18\n" +
                        "9\n" +
                        "2026\n" +
                        "Ms. Roldan\n" +
                        "11\n" +
                        "St. Isidore of Seville\n" +
                        "yes\n";

        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(simulatedInput.getBytes());

        Scanner input = new Scanner(inputStream);

        System.out.println("\n==============================");
        System.out.println("DELIVER REQUIREMENT");
        System.out.println("==============================");

        deliverRequirement(input);

        input.close();
    }

    public void deliverRequirement(Scanner input) {

        System.out.print("Enter Date Day: ");
        int day = input.nextInt();

        System.out.print("Enter Date Month: ");
        int month = input.nextInt();

        System.out.print("Enter Date Year: ");
        int year = input.nextInt();

        input.nextLine();

        System.out.print("Enter Teacher Name: ");
        String teacherName = input.nextLine();

        System.out.print("Enter Target Grade: ");
        int targetGrade = input.nextInt();

        input.nextLine();

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

        System.out.println("\n--- Requirement Information ---");
        System.out.println("Upload Date: " +
                day + "/" + month + "/" + year);

        System.out.println("Teacher Name: " + teacherName);
        System.out.println("Target Grade: " + targetGrade);
        System.out.println("Target Section: " + targetSection);
        System.out.println("Notification Sent: " + notificationSent);
    }


    // ==============================
    // 3. LIST OF REQUIREMENTS
    // ==============================
    @Test
    public void testListOfRequirements() {

        String simulatedInput =
                "Computer Programming\n" +
                        "3\n" +
                        "Java Activity\n" +
                        "Programming Exercise\n" +
                        "Mini Project\n";

        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(simulatedInput.getBytes());

        Scanner input = new Scanner(inputStream);

        System.out.println("\n==============================");
        System.out.println("LIST OF REQUIREMENTS");
        System.out.println("==============================");

        listOfRequirements(input);

        input.close();
    }

    public void listOfRequirements(Scanner scanner) {

        System.out.println(
                "=== SMART-PACK: LIST OF REQUIREMENTS ==="
        );

        System.out.print("Enter subject: ");
        String subject = scanner.nextLine();

        System.out.print("Enter number of requirements: ");
        int number = scanner.nextInt();

        scanner.nextLine();

        String[] requirements =
                new String[number];

        for (int i = 0; i < number; i++) {

            System.out.print(
                    "Enter requirement " + (i + 1) + ": "
            );

            requirements[i] =
                    scanner.nextLine();
        }

        System.out.println(
                "\n=== REQUIREMENTS FOR " + subject + " ==="
        );

        for (int i = 0; i < number; i++) {

            System.out.println(
                    (i + 1) + ". " + requirements[i]
            );
        }
    }
}