package com.example.smartpack.quarter2_MiniPeta3;

import java.util.Scanner;

class ListOfRequirements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SMART-PACK: LIST OF REQUIREMENTS ===");

        System.out.print("Enter subject: ");
        String subject = scanner.nextLine();

        System.out.print("Enter number of requirements: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        String[] requirements = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.print("Enter requirement " + (i + 1) + ": ");
            requirements[i] = scanner.nextLine();
        }

        System.out.println("\n=== REQUIREMENTS FOR " + subject + " ===");

        for (int i = 0; i < number; i++) {
            System.out.println((i + 1) + ". " + requirements[i]);
        }

        scanner.close();

    }
}



