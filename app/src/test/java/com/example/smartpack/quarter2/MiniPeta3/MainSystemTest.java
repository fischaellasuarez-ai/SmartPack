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
         * A StringBuilder acts as our virtual keyboard.
         * Instead of physically typing into the console,
         * we add every word or number the user would type.
         */
        StringBuilder simulatedUserInput =
                new StringBuilder();

        System.out.println(
                "\n-------------------------------"
        );
        System.out.println(
                "       SmartPack System"
        );
        System.out.println(
                "-----------------------------------"
        );


        /*
         * PART 1: LOGIN
         *
         * These inputs simulate the user choosing Login,
         * entering the username, and entering the password.
         */

        System.out.println(
                "\nGenerating Login inputs..."
        );

        simulatedUserInput.append("Login\n");
        simulatedUserInput.append("Max\n");
        simulatedUserInput.append("1234\n");


        /*
         * PART 2: NOTIFICATION UPLOAD
         *
         * These inputs simulate the teacher entering
         * the subject and requirement.
         */

        System.out.println(
                "Generating Notification Upload inputs..."
        );

        simulatedUserInput.append("Math\n");
        simulatedUserInput.append("1 whiteboard\n");


        /*
         * PART 3: DELIVER NOTIFICATION
         *
         * These inputs simulate the teacher entering
         * the date, teacher name, target grade,
         * target section, and notification status.
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
         *
         * These inputs simulate the user entering
         * two additional requirements.
         */

        System.out.println(
                "Generating List of Requirements inputs..."
        );

        simulatedUserInput.append("2\n");
        simulatedUserInput.append("BlackMarker\n");
        simulatedUserInput.append(
                "coloring materials\n"
        );


        System.out.println(
                "\n--- INPUT COMPLETE ---"
        );


        /*
         * 2. THE MAGIC CONVERSION
         *
         * This converts all the simulated inputs
         * into an InputStream.
         *
         * It allows Java to read the StringBuilder
         * as if the inputs came from a keyboard.
         */
        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(
                        simulatedUserInput
                                .toString()
                                .getBytes()
                );


        /*
         * 3. THE AUTOMATED SCANNER
         *
         * The Scanner reads the simulated inputs.
         *
         * Whenever the SmartPack program uses
         * nextInt() or nextLine(), it reads
         * from the simulated keyboard.
         */
        Scanner scanner =
                new Scanner(inputStream);


        /*
         * 4. RUNNING YOUR ACTUAL SMART-PACK SYSTEM
         *
         * Create an object of the Suarez_MainMenu class.
         * Then use start(scanner) to run all parts
         * of the SmartPack system.
         */
        Suarez_MainMenu mainSystem =
                new Suarez_MainMenu();

        mainSystem.start(scanner);


        /*
         * 5. TEST COMPLETE
         *
         * This message shows that the automated
         * SmartPack system test has finished.
         */
        System.out.println(
                "\n-------------------------------"
        );
        System.out.println(
                "       TEST COMPLETE"
        );
        System.out.println(
                "-----------------------------------"
        );


        scanner.close();
    }
}