package com.example.smartpack.quarter2_MiniPeta3;

import java.util.Scanner;

 class NotificationUpload
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        String subject;
        String requirement;

        System.out.print("Enter Subject: ");
        subject = input.nextLine();

        System.out.print("Enter Requirement: ");
        requirement = input.nextLine();

        if(subject.isEmpty() || requirement.isEmpty())
        {
            System.out.println("Upload Failed");
            System.out.println("Subject or Requirement is empty.");
        }
        else
        {
            System.out.println("Requirement Uploaded Successfully");
            System.out.println("------------------------------");
            System.out.println("Subject: " + subject);
            System.out.println("Requirement:  " + requirement);
        }
    }

    public static class Notification_Upload {
    }
}