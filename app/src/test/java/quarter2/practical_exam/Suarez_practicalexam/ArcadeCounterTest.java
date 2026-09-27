package quarter2.practical_exam.Suarez_practicalexam;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class ArcadeCounterTest {

    @Test
    public void testArcadeFlow() {
        StringBuilder automatedInput = new StringBuilder();

        System.out.println("--- GENERATING ARCADE TEST DATA ---");

        // Step 1: Buy tokens option
        automatedInput.append("1\n"); // Choose Buy Tokens

        // Step 2: Test low ticket count for prize (< 500)
        automatedInput.append("2\n"); // Choose Claim Prize
        automatedInput.append("200\n"); // Insert 200 tickets (Expected: Keep Playing)

        // Step 3: Test high ticket count for prize (>= 500)
        automatedInput.append("2\n"); // Choose Claim Prize
        automatedInput.append("600\n"); // Insert 600 tickets (PRIZE: PLUSHY)
        automatedInput.append("800\n"); // Insert 800 tickets (PRIZE: TEADY BEAR )
        automatedInput.append("1000\n"); // Insert 1000 tickets (PRIZE: RC CAR)

        // Step 4: Exit system
        automatedInput.append("3\n"); // Choose Exit

        System.out.println("--- TEST DATA GENERATION COMPLETE ---\n");

        ByteArrayInputStream inputStream = new ByteArrayInputStream(automatedInput.toString().getBytes());
        Scanner scanner = new Scanner(inputStream);
        ArcadeCounter arcadeSystem = new ArcadeCounter();
        arcadeSystem.start(scanner);
    }
}

