package quarter2.practical_exam.Pecore_practicalexam;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class GymAccessTest<GymAccess> {

    @Test
    public void testGymFlow() {

        StringBuilder automatedInput = new StringBuilder();

        System.out.println("--- GENERATING GYM TEST DATA ---");

        // =====================================
        // ENTER GYM
        // =====================================

        automatedInput.append("1\n");

        // Cardio Area
        automatedInput.append("1\n");

        // Weightlifting Area
        automatedInput.append("2\n");

        // Exercise Area
        automatedInput.append("3\n");

        // Return to Main Menu
        automatedInput.append("4\n");


        // =====================================
        // MEMBERSHIP MENU
        // =====================================

        automatedInput.append("2\n");

        // VIP
        automatedInput.append("1\n");

        // Basic
        automatedInput.append("2\n");

        // Compare
        automatedInput.append("3\n");

        // Return
        automatedInput.append("4\n");


        // =====================================
        // TRAINER MENU
        // =====================================

        automatedInput.append("3\n");

        // Hire Trainer
        automatedInput.append("1\n");

        // VIP Level 1
        automatedInput.append("1\n");

        // Hire Trainer again
        automatedInput.append("1\n");

        // Basic Level 2
        automatedInput.append("2\n");

        // Trainer Information
        automatedInput.append("2\n");

        // Return
        automatedInput.append("3\n");


        // =====================================
        // GYM SCHEDULE
        // =====================================

        automatedInput.append("4\n");

        // Monday
        automatedInput.append("1\n");

        // Wednesday
        automatedInput.append("3\n");

        // Saturday
        automatedInput.append("6\n");

        // Return
        automatedInput.append("8\n");


        // =====================================
        // EXIT
        // =====================================

        automatedInput.append("5\n");


        System.out.println("--- TEST DATA GENERATION COMPLETE ---\n");


        // =====================================
        // CREATE AUTOMATED INPUT
        // =====================================

        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(
                        automatedInput.toString().getBytes()
                );

        Scanner scanner = new Scanner(inputStream);


        // =====================================
        // START GYM SYSTEM
        // =====================================

        GymAccess gymSystem = new GymAccess();

        gymSystem.notifyAll(scanner);


        // =====================================
        // CLOSE SCANNER
        // =====================================

        scanner.close();

        System.out.println("\n--- GYM TEST COMPLETE ---");
    }
}
