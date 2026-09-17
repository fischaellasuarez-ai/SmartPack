
package com.example.smartpack.quarter2_MiniPeta3;

import java.util.Scanner;

        public class Suarez_Minipeta3 {
            //the delivering of requirments
            public static void main(String[] args) {

                Scanner input = new Scanner(System.in);
                //code for the information placing.
                System.out.print("Enter Name: ");
                String Name = input.nextLine();

                System.out.print("Subject Name: ");
                String Subject= input.nextLine();

                System.out.print("Notification title: ");
                String Title = input.nextLine();

                System.out.print("Notification context: ");
                String Context = input.nextLine();

                System.out.print("Enter a requirement: ");
                String requirement = input.nextLine();

                System.out.print("Notification date: ");
                String Date = input.nextLine();

                //where the information will be placed.
                System.out.println("Name: " + Name);
                System.out.println(" ");
                System.out.println("Subject: " + Subject);
                System.out.println(" ");
                System.out.println("Title: " + Title);
                System.out.println(" ");
                System.out.println("Context: "+ Context);
                System.out.println(" ");
                System.out.println("Requirement " + requirement);
                System.out.println(" ");
                System.out.println("Date " + Date);
                System.out.println(" ");


                System.out.println(" ");

                //after the information was placed this will be displayed on the students side.
                System.out.println("NOTIFICATION FROM" + Name);

                System.out.println(Subject);
                System.out.println(" ");

                System.out.println(Title);
                System.out.println(" ");

                System.out.println(Context);
                System.out.println(" ");

                System.out.println(requirement);
                System.out.println(" ");

                System.out.println(Date);
                input.close();
            }
        }
