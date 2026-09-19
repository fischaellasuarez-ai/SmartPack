package com.example.smartpack.quarter2_MiniPeta3;

import java.util.Scanner;

class Deliverrequirment {

    // The delivering of requirements
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

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
        System.out.println("\n--- Requirement Information ---");
        System.out.println("Upload Date: " + day + "/" + month + "/" + year);
        System.out.println("Teacher Name: " + teacherName);
        System.out.println("Target Grade: " + targetGrade);
        System.out.println("Target Section: " + targetSection);
        System.out.println("Notification  Sent: " + notificationSent);

        input.close();
    }

    public static class DeliverRequirment {
    }
}

