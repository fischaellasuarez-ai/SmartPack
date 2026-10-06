package quarter2.practical_exam.Delavega_practical_exam;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CinemaTicketingTest {

    @Test
    public void testCinemaFlow() {

        // Automated user input
        String automatedInput =
                "1\n" +   // Buy Ticket
                        "15\n" +  // Age 15 - should be denied
                        "1\n" +   // Buy Ticket again
                        "20\n" +  // Age 20 - should be allowed
                        "2\n" +   // Buy Snacks
                        "3\n";    // Exit

        System.out.println("--- GENERATING CINEMA TEST DATA ---");
        System.out.println(automatedInput);
        System.out.println("--- TEST DATA GENERATION COMPLETE ---");

        // Convert automated input into an input stream
        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(
                        automatedInput.getBytes(StandardCharsets.UTF_8)
                );


    }
}