package quarter2.practical_exam.Roldan_practicalexam;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class LibraryKioskTest {

    @Test
    public void testLibraryFlow() {
        StringBuilder automatedInput = new StringBuilder();

        System.out.println("Generating Library Test Data...");

        // Step 1: Borrow book option
        automatedInput.append("1\n"); // Choose Borrow Book

        // Step 2: Test insufficient fine payment (< 15)
        automatedInput.append("2\n"); // Choose Pay Fines
        automatedInput.append("10\n"); // Enter payment 10 (Expected: Insufficient)

        // Step 3: Test sufficient fine payment (>= 15)
        automatedInput.append("2\n"); // Choose Pay Fines
        automatedInput.append("50\n"); // Enter Payment 50 (Expected: Change calculation)

        // Step 4: Exit System
        automatedInput.append("3\n"); // Choose Exit

        System.out.println("Test Data Generation COMPLETE!\n");

        ByteArrayInputStream inputStream = new ByteArrayInputStream(automatedInput.toString().getBytes());
        Scanner scanner = new Scanner(inputStream);

        LibraryMenu librarySystem = new LibraryMenu();
        librarySystem.start(scanner);
    }
}