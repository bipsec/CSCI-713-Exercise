import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class UtilsTest {

    // Test checkName method
    @Test
    void testCheckNameValidName() {
        assertTrue(Utils.checkName("Alice"));
        assertTrue(Utils.checkName("Bob"));
        assertTrue(Utils.checkName("John Doe"));
    }

    @Test
    void testCheckNameEmptyString() {
        assertFalse(Utils.checkName(""));
    }

    @Test
    void testCheckNameNull() {
        assertFalse(Utils.checkName(null));
    }

    @Test
    void testCheckNameSingleCharacter() {
        assertTrue(Utils.checkName("A"));
    }

    @Test
    void testCheckNameWhitespaceOnly() {
        // Note: " " has length > 0, so it returns true
        // This might be a bug depending on requirements
        assertTrue(Utils.checkName(" "));
    }

    @Test
    void testCheckNameLongString() {
        String longName = "A".repeat(1000);
        assertTrue(Utils.checkName(longName));
    }

    // Test isValidAge method
    @Test
    void testIsValidAgePositiveAge() {
        assertTrue(Utils.isValidAge(1));
        assertTrue(Utils.isValidAge(25));
        assertTrue(Utils.isValidAge(100));
    }

    @Test
    void testIsValidAgeZero() {
        assertTrue(Utils.isValidAge(0));
    }

    @Test
    void testIsValidAgeNegative() {
        assertFalse(Utils.isValidAge(-1));
        assertFalse(Utils.isValidAge(-100));
    }

    @Test
    void testIsValidAgeVeryLarge() {
        // Note: Bug in implementation - allows age > 120
        assertTrue(Utils.isValidAge(121));
        assertTrue(Utils.isValidAge(200));
        assertTrue(Utils.isValidAge(1000));
    }

    @Test
    void testIsValidAgeBoundaryValues() {
        assertTrue(Utils.isValidAge(120));
        assertTrue(Utils.isValidAge(Integer.MAX_VALUE));
    }

    // Test printMessage method
    @Test
    void testPrintMessageValidMessage() {
        // Capture System.out
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Utils.printMessage("Hello World");
            String output = outputStream.toString();
            assertTrue(output.contains("Hello World"));
        } finally {
            // Restore original System.out
            System.setOut(originalOut);
        }
    }

    @Test
    void testPrintMessageEmptyString() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Utils.printMessage("");
            String output = outputStream.toString();
            assertEquals("" + System.lineSeparator(), output);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testPrintMessageNull() {
        // Should not throw NullPointerException
        assertDoesNotThrow(() -> {
            Utils.printMessage(null);
        });
    }

    @Test
    void testPrintMessageSpecialCharacters() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Utils.printMessage("Test\nMessage\tWith\tTabs");
            String output = outputStream.toString();
            assertTrue(output.contains("Test"));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testPrintMessageLongMessage() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            String longMessage = "A".repeat(1000);
            Utils.printMessage(longMessage);
            String output = outputStream.toString();
            assertTrue(output.contains("A".repeat(1000)));
        } finally {
            System.setOut(originalOut);
        }
    }
}

