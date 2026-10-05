package com.example.smartpack.quarter2;

import org.junit.Test;

public class Delavega_minipeta2 {
    @Test
    public void printMyProfile() {
        String myName = "John";
        String petName = "Piona";
        String favFood = "sinigang";
        int myAge = 15;

        System.out.println("<My DIGITAL Profile>");
        System.out.println("Hello! You may call me " + myName + " and currently, " + myAge + " years old.");
        System.out.println("I have a 2 adorable cats named " + petName + ".");
        System.out.println("the food i craved the most is " + favFood + ".");
    }
}