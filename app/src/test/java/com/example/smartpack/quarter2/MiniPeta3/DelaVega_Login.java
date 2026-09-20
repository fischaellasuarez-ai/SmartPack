package com.example.smartpack.quarter2.MiniPeta3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class DelaVega_Login {

    @Test
    public void Login() {

        // Simulated user input
        String simulatedInput =
                "Login\n" +
                        "Max\n" +
                        "1234\n";

        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(simulatedInput.getBytes());

        Scanner input = new Scanner(inputStream);

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

            if (username.equals("Sixson") && password.equals("1234")) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Incorrect username or password.");
            }

        } else if (choice.equalsIgnoreCase("Sign in")) {

            System.out.println("\n--- SIGN IN ---");

            System.out.println("Enter Email: ");
            String email = input.nextLine();

            System.out.println("Create password: ");
            String password = input.nextLine();

            System.out.print("Account created successfully! ");

        } else {

            System.out.println("Unknown option.");
        }

        input.close();
    }
}