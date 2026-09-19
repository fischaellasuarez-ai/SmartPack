package com.example.smartpack.quarter2_MiniPeta3;

import java.util.Scanner;

class login {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Login or Sign in: ");
        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("Login")) {

            System.out.println("\n--- LOGIN ---");

            System.out.print("Enter username: ");
            String username = input.nextLine();

            System.out.print("Enter password: ");
            String password = input.nextLine();

            if (username.equals("Max") && password.equals("1234")) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Incorrect username or password.");
            }

        } else if (choice.equalsIgnoreCase("Sign in")) {

            System.out.println("\n--- SIGN IN ---");

            System.out.print("Enter Email: ");
            String email = input.nextLine();

            System.out.print("Create password: ");
            String password = input.nextLine();

            System.out.println("Account created successfully!");

        } else {

            System.out.println("Unknown option.");
        }

        input.close();
    }
}