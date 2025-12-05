import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class MainTest {

    @Test
    void testMainMethodExecution() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Main.main(new String[]{});
            String output = outputStream.toString();
            
            assertTrue(output.contains("Top Student:"));
            assertTrue(output.contains("Average GPA:"));
            assertTrue(output.contains("Removing student 'Bob'..."));
            assertTrue(output.contains("Average GPA after removal:"));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMainMethodOutputContainsTopStudent() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Main.main(new String[]{});
            String output = outputStream.toString();
            
            assertTrue(output.contains("Top Student:"));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMainMethodOutputContainsAverageGpa() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Main.main(new String[]{});
            String output = outputStream.toString();
            
            assertTrue(output.contains("Average GPA:"));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMainMethodOutputContainsRemovalMessage() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Main.main(new String[]{});
            String output = outputStream.toString();
            
            assertTrue(output.contains("Removing student 'Bob'..."));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMainMethodOutputContainsAverageGpaAfterRemoval() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Main.main(new String[]{});
            String output = outputStream.toString();
            
            assertTrue(output.contains("Average GPA after removal:"));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMainMethodDoesNotThrowException() {
        assertDoesNotThrow(() -> {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outputStream));
            try {
                Main.main(new String[]{});
            } finally {
                System.setOut(originalOut);
            }
        });
    }

    @Test
    void testMainMethodWithEmptyArgs() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Main.main(new String[]{});
            String output = outputStream.toString();
            assertNotNull(output);
            assertFalse(output.isEmpty());
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMainMethodWithNullArgs() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Main.main(null);
            String output = outputStream.toString();
            assertNotNull(output);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMainMethodOutputFormat() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Main.main(new String[]{});
            String output = outputStream.toString();
            
            String[] lines = output.split(System.lineSeparator());
            assertTrue(lines.length > 0);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMainMethodExecutesWithoutError() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Main.main(new String[]{});
            String output = outputStream.toString();
            assertNotNull(output);
        } catch (Exception e) {
            fail("Main.main should not throw exceptions: " + e.getMessage());
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMainMethodWithArgs() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Main.main(new String[]{"arg1", "arg2"});
            String output = outputStream.toString();
            assertNotNull(output);
            assertTrue(output.contains("Top Student:"));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMainMethodOutputContainsStudentNames() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Main.main(new String[]{});
            String output = outputStream.toString();
            
            assertTrue(output.contains("Bob") || output.contains("Alice") || output.contains("Charlie"));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMainMethodOutputContainsNewline() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Main.main(new String[]{});
            String output = outputStream.toString();
            
            assertTrue(output.contains("\n") || output.contains(System.lineSeparator()));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMainMethodOutputLength() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Main.main(new String[]{});
            String output = outputStream.toString();
            
            assertTrue(output.length() > 50);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMainMethodMultipleExecutions() {
        ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
        ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(outputStream1));
            Main.main(new String[]{});
            String output1 = outputStream1.toString();

            System.setOut(new PrintStream(outputStream2));
            Main.main(new String[]{});
            String output2 = outputStream2.toString();

            assertEquals(output1, output2);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMainMethodOutputOrder() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Main.main(new String[]{});
            String output = outputStream.toString();
            
            int topStudentIndex = output.indexOf("Top Student:");
            int avgGpaIndex = output.indexOf("Average GPA:");
            int removalIndex = output.indexOf("Removing student");
            int afterRemovalIndex = output.indexOf("Average GPA after removal:");
            
            assertTrue(topStudentIndex >= 0);
            assertTrue(avgGpaIndex > topStudentIndex);
            assertTrue(removalIndex > avgGpaIndex);
            assertTrue(afterRemovalIndex > removalIndex);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMainMethodOutputDoesNotContainImpossible() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Main.main(new String[]{});
            String output = outputStream.toString();
            
            assertFalse(output.contains("Impossible"));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMainMethodWithSingleArg() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Main.main(new String[]{"test"});
            String output = outputStream.toString();
            assertNotNull(output);
            assertTrue(output.length() > 0);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMainMethodOutputContainsColon() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Main.main(new String[]{});
            String output = outputStream.toString();
            
            assertTrue(output.contains(":"));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMainMethodOutputContainsNumbers() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Main.main(new String[]{});
            String outputStr = outputStream.toString();
            
            boolean containsNumber = false;
            for (char c : outputStr.toCharArray()) {
                if (Character.isDigit(c)) {
                    containsNumber = true;
                    break;
                }
            }
            assertTrue(containsNumber, "Output should contain numbers. Output: " + outputStr);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMainMethodOutputCompleteFlow() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Main.main(new String[]{});
            String output = outputStream.toString();
            
            assertTrue(output.contains("Top Student:"));
            assertTrue(output.contains("Average GPA:"));
            assertTrue(output.contains("Removing"));
            assertTrue(output.contains("after removal"));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMainMethodWithManyArgs() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Main.main(new String[]{"arg1", "arg2", "arg3", "arg4", "arg5"});
            String output = outputStream.toString();
            assertNotNull(output);
            assertTrue(output.length() > 0);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMainMethodOutputVerification() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Main.main(new String[]{});
            String output = outputStream.toString();
            
            String[] requiredStrings = {
                "Top Student:",
                "Average GPA:",
                "Removing student",
                "Average GPA after removal:"
            };
            
            for (String required : requiredStrings) {
                assertTrue(output.contains(required), "Output should contain: " + required);
            }
        } finally {
            System.setOut(originalOut);
        }
    }
}

