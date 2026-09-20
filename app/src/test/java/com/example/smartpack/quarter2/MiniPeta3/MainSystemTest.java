package com.example.smartpack.quarter2.MiniPeta3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class MainSystemTest {

    @Test
    public void testCompleteSystemFlow() {

        /*
         * 1. THE VIRTUAL KEYBOARD
         *
         * StringBuilder stores everything that
         * the user would normally type.
         */
        StringBuilder simulatedUserInput =
                new StringBuilder();

        System.out.println(
                "--- GENERATING SIMULATED USER INPUTS ---"
        );


        /*
         * PART 1: LOGIN
         */

        System.out.println(
                "Generating Login inputs..."
        );

        simulatedUserInput.append("Login\n");
        simulatedUserInput.append("Max\n");
        simulatedUserInput.append("1234\n");


        /*
         * PART 2: NOTIFICATION UPLOAD
         */

        System.out.println(
                "Generating Notification Upload inputs..."
        );

        simulatedUserInput.append("Math\n");
        simulatedUserInput.append("1 whiteboard\n");


        /*
         * PART 3: DELIVER REQUIREMENT
         */

        System.out.println(
                "Generating Deliver Requirement inputs..."
        );

        simulatedUserInput.append("18\n");
        simulatedUserInput.append("9\n");
        simulatedUserInput.append("2026\n");
        simulatedUserInput.append("Ms. Roldan\n");
        simulatedUserInput.append("11\n");
        simulatedUserInput.append(
                "St. Isidore of Seville\n"
        );
        simulatedUserInput.append("yes\n");


        /*
         * PART 4: LIST OF REQUIREMENTS
         */

        System.out.println(
                "Generating List of Requirements inputs..."
        );

        // Number of additional requirements
        simulatedUserInput.append("2\n");

        // Additional requirement #1
        simulatedUserInput.append("BlackMarker\n");

        // Additional requirement #2
        simulatedUserInput.append(
                "coloring materials\n"
        );


        System.out.println(
                "--- INPUT GENERATION COMPLETE ---\n"
        );


        /*
         * 2. THE MAGIC CONVERSION
         *
         * Convert the StringBuilder into an InputStream.
         */
        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(
                        simulatedUserInput
                                .toString()
                                .getBytes()
                );


        /*
         * 3. THE AUTOMATED SCANNER
         */
        Scanner scanner =
                new Scanner(inputStream);


        /*
         * 4. RUN THE ACTUAL SMART-PACK SYSTEM
         */
        Suarez_MainMenu mainSystem =
                new Suarez_MainMenu();


        mainSystem.start(scanner);


        /*
         * Close the Scanner after the test.
         */
        scanner.close();
    }
}