package com.example.smartpack.quarter2_MiniPeta3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Suarez_MainMenu {


    String subject;
    String requirement;


    //Main Menu test
    @Test
    public void MainMenu() {

        String simulatedInput =
                // LOGIN
                "Login\n" +
                        "Max\n" +
                        "1234\n" +

                        // NOTIFICATION UPLOAD
                        "Math\n" +
                        "1 whiteboard\n" +

                        // DELIVER REQUIREMENT
                        "18\n" +
                        "9\n" +
                        "2026\n" +
                        "Ms. Roldan\n" +
                        "11\n" +
                        "St. Isidore of Seville\n" +
                        "yes\n" +

                        // LIST OF REQUIREMENTS
                        "2\n" +
                        "BlackMarker\n" +
                        "coloring materials\n";


        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(simulatedInput.getBytes());

        Scanner input = new Scanner(inputStream);


        //Lgoin(Dela Vega)
        System.out.println("\n-------------------------- --");
        System.out.println("LOGIN");
        System.out.println("-----------------------------");

        Login(input);


        //(Notification Upload(Pecore)
        System.out.println("\n-----------------------------");
        System.out.println("NOTIFICATION UPLOAD");
        System.out.println("-----------------------------");

        notificationUpload(input);


        //Deliver Requirments(Roldan)
        System.out.println("\n-----------------------------");
        System.out.println("DELIVER REQUIREMENT");
        System.out.println("-----------------------------");

        deliverRequirement(input);


        //List or Requirements(Rufino)
        System.out.println("\n-----------------------------");
        System.out.println("LIST OF REQUIREMENTS");
        System.out.println("-----------------------------");

        listOfRequirements(input);


        input.close();
    }


   //Login (Dela Vega)
    public void Login(Scanner input) {

        System.out.print("Enter Login or Sign in: ");
        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("Login")) {

            System.out.println("\n--- LOGIN ---");

            System.out.print("Enter username: ");
            String username = input.nextLine();

            System.out.println(username);

            System.out.print("Enter password: ");
            String password = input.nextLine();

            System.out.println(password);

            if (username.equals("Max") &&
                    password.equals("1234")) {

                System.out.println("Login successful!");

            } else {

                System.out.println(
                        "Incorrect username or password."
                );
            }

        } else if (choice.equalsIgnoreCase("Sign in")) {

            System.out.println("\n--- SIGN IN ---");

            System.out.print("Enter Email: ");
            String email = input.nextLine();

            System.out.print("Create password: ");
            String password = input.nextLine();

            System.out.println(
                    "Account created successfully!"
            );

        } else {

            System.out.println("Unknown option.");
        }
    }


    //(Notification Upload(Pecore)
    public void notificationUpload(Scanner input) {

        System.out.print("Enter Subject: ");
        subject = input.nextLine();

        System.out.print("Enter Requirement: ");
        requirement = input.nextLine();

        if (subject.isEmpty() ||
                requirement.isEmpty()) {

            System.out.println("Upload Failed");

            System.out.println(
                    "Subject or Requirement is empty."
            );

        } else {

            System.out.println(
                    "Requirement Uploaded Successfully"
            );

            System.out.println(
                    "------------------------------"
            );

            System.out.println(
                    "Subject: " + subject
            );

            System.out.println(
                    "Requirement: " + requirement
            );
        }
    }

    //Deliver Requirments(Roldan)
    public void deliverRequirement(Scanner input) {

        // The delivering of requirements

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

        System.out.print(
                "Was the notification sent? (yes/no): "
        );

        String answer = input.nextLine();

        boolean notificationSent;

        if (answer.equalsIgnoreCase("yes")) {

            notificationSent = true;

        } else {

            notificationSent = false;
        }


        //where information will be displayed
        System.out.println(
                "\n--- Requirement Information ---"
        );

        // CONNECTED FROM NOTIFICATION UPLOAD
        System.out.println(
                "Subject: " + subject
        );

        System.out.println(
                "Requirement: " + requirement
        );

        System.out.println(
                "Upload Date: " +
                        day + "/" + month + "/" + year
        );

        System.out.println(
                "Teacher Name: " + teacherName
        );

        System.out.println(
                "Target Grade: " + targetGrade
        );

        System.out.println(
                "Target Section: " + targetSection
        );

        System.out.println(
                "Notification Sent: " +
                        notificationSent
        );
    }


    //List or Requirements(Rufino)
    public void listOfRequirements(Scanner scanner) {

        System.out.println(
                "=== SMART-PACK: LIST OF REQUIREMENTS ==="
        );

        // CONNECTED FROM NOTIFICATION UPLOAD
        System.out.println(
                "Subject: " + subject
        );

        System.out.println(
                "Uploaded Requirement: " +
                        requirement
        );

        System.out.print(
                "Enter number of additional requirements: "
        );

        int number = scanner.nextInt();

        scanner.nextLine();

        String[] requirements =
                new String[number];


        for (int i = 0; i < number; i++) {

            System.out.print(
                    "Enter requirement " +
                            (i + 1) + ": "
            );

            requirements[i] =
                    scanner.nextLine();
        }


        System.out.println(
                "\n=== REQUIREMENTS FOR " +
                        subject + " ==="
        );

        // REQUIREMENT FROM NOTIFICATION UPLOAD
        System.out.println(
                "1. " + requirement
        );


        // ADDITIONAL REQUIREMENTS
        for (int i = 0; i < number; i++) {

            System.out.println(
                    (i + 2) + ". " +
                            requirements[i]
            );
        }
    }
}